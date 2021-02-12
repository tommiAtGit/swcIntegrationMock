package com.swc.integration.tester.swcIntegrationMock.service;

import java.net.URI;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swc.integration.tester.swcIntegrationMock.model.Network;
import com.swc.integration.tester.swcIntegrationMock.model.web.NetworkDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NetworkServiceImpl implements NetworkService {

	private static RestTemplate restTemplate;
	
	@Value("${swc.network.url}")
	private String networUrl;
	 
	@Value("${swc.network.token}")
	private String networkApiToken; 
	
	@Value("${swc.network.sendflag}")
	private String sendFlag;
	
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public Network saveNetwork(NetworkDto networkDto) {
		
		log.info("..Network received with following parameters: " + networkDto.getUuid() + " " + networkDto.getName() );
	
		Network network =  Network.builder()
				.uuid(networkDto.getUuid())
				.name(networkDto.getName())
				.description(networkDto.getDescription())
				.build();
		
		
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(network);
			log.info("..at saveNetwork, object as Json:  " + objectAsJson); 
			if (sendFlag.equals("TRUE")) {
				log.info(" ");
				log.info("+ Send network + ");
				createNetwork(network);
				log.info("End of network send ");
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
	
		return network;
	}
	
	private  ResponseEntity<String> createNetwork(Network network){
		final String serviceUrl = "/networks";
		final String baseUrl = networUrl+serviceUrl;

		
		log.info("++ Start of Network post: " + LocalDateTime.now() + "++");    
		if (network == null) {
			log.error("..at createNetwork, no network aviable:  ");  
			return null;
		}
		URI uri = null;
	    
		ResponseEntity<String> result = null;
		
	    try {
	    	log.info(".. At createNetwork, baseurl:  " + baseUrl);  
	    	
			
			uri = new URI(baseUrl);
		
			restTemplate = new RestTemplate();
			
		
			HttpEntity<Network> request = new HttpEntity<>(network, defineHeaders());
			result = restTemplate.postForEntity(uri, request, String.class); 
					
			
			
		
	    } catch (Exception e) {
	    	log.error("..at createNetwork, Error occured:  "); 
			e.printStackTrace();
			return null;
		}
		
		log.info("End of network post: " + LocalDateTime.now());        
		
		return result;
	}

	private HttpHeaders  defineHeaders() {
		
		String token = networkApiToken;
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(token);
		headers.set("Accept", "application/vnd.alva.swc.network+json;v=1");
	    return headers;
	    
	}
}
