package com.swc.integration.tester.swcIntegrationMock.service;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swc.integration.tester.swcIntegrationMock.model.Hydrant;
import com.swc.integration.tester.swcIntegrationMock.model.web.HydrantDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HydrantServiceImpl implements HydrantService {

	private ObjectMapper mapper = new ObjectMapper();
	private static int SAMPLE_SIZE = 3;
	private static RestTemplate restTemplate;
	@Value("${swc.network.url}")
	private String networUrl;
	 
	@Value("${swc.network.token}")
	private String networkApiToken; 
	
	@Override
	public Hydrant saveHydrant(String network, List<HydrantDto> hydrantDto) {
		
		List<Hydrant> sampleHydrants = new ArrayList<Hydrant>();
		List<Hydrant> hydrants = new ArrayList<Hydrant>();
		Hydrant hyd = null;
		int index = 0;
		
		for (HydrantDto dto : hydrantDto) {
			hyd = Hydrant.builder()
					.uuid(dto.getUuid())
					.name(dto.getName())
					.description(dto.getDescription())
					.quality(dto.getQuality())
					//.source(dto.getSource())
					.coordinates(dto.getCoordinates())
					.open_time(dto.getOpen_time())
					.close_time(dto.getClose_time())
					.max_flow(dto.getMax_flow())
					.min_pressure(dto.getMin_pressure())
					.diameter(dto.getDiameter())
					.build();
			
			
			if (index < SAMPLE_SIZE) {
				sampleHydrants.add(hyd);
				index++;
			}
			hydrants.add(hyd);
		}
		
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(sampleHydrants);
			log.info("..at saveHydrant, object as Json:  " + objectAsJson); 
			log.info(" "); 
			log.info(" + Post hydrants + "); 
			createHydrants(network,hydrants);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
		
		return null;
	}
	//Send test gateValves
		private  ResponseEntity<String> createHydrants (String network,List<Hydrant> hydrants) {
			final String serviceUrl = "/networks/" + network +  "/hydrants";
			final String baseUrl = networUrl+serviceUrl;
			
			int postIndex = 0; 
			int stepSize = 100;
			
			log.info("++ Start of Hydrant post: " + LocalDateTime.now() + "++");    
			if ((hydrants == null)|| (hydrants.size() < 1))  {
				log.error("..at createHydrants, no hydrants aviable:  ");  
				return null;
			}
			URI uri = null;
		    
			ResponseEntity<String> result = null;
			
		    try {
		    	log.info(".. At ,createHydrants baseurl:  " + baseUrl);  
		    	
				
				uri = new URI(baseUrl);
			
				restTemplate = new RestTemplate();
				for (Hydrant hydrant : hydrants) {
					postIndex++;
					HttpEntity<Hydrant> request = new HttpEntity<>(hydrant, defineHeaders());
					result = restTemplate.postForEntity(uri, request, String.class); 
					if (postIndex % stepSize == 0) {
						log.info("Hydrant: " + postIndex + " send with result: " + result.getStatusCode());  
					}
					
				}
				
			
		    } catch (Exception e) {
		    	log.error("..at createHydrants, Error occured:  "); 
				e.printStackTrace();
				return null;
			}
			
			log.info("End of Hydrant post: " + LocalDateTime.now());        
			
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
