package com.swc.integration.tester.swcIntegrationMock.service;

import java.net.URI;
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
import com.swc.integration.tester.swcIntegrationMock.model.Junction;
import com.swc.integration.tester.swcIntegrationMock.model.web.JunctionDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JunctionServiceImpl implements JunctionService {

	private ObjectMapper mapper = new ObjectMapper();
	private static int SAMPLE_SIZE = 6;
	private static RestTemplate restTemplate;
	@Value("${swc.network.url}")
	private String networUrl;
	 
	@Value("${swc.network.token}")
	private String networkApiToken; 
	
	@Override
	public Junction saveJunction(List<JunctionDto> junctionDtos,String network) {
		Junction junction = null;
		List<Junction> junctions = new ArrayList<Junction>();
		List<Junction> allJunctions = new ArrayList<Junction>();
		List<Junction> printJunctions = new ArrayList<Junction>();
		int index = 0;
		
		for (JunctionDto junctionDto : junctionDtos) {
			junction = Junction.builder()
					.uuid(junctionDto.getUuid())
					.name(junctionDto.getName())
					.description(junctionDto.getDescription())
					.quality(junctionDto.getQuality())
					//.source(junctionDto.getSource())
					.coordinates(junctionDto.getCoordinates())
					.elevation(junctionDto.getElevation())
					//.demand(junctionDto.getDemand())
					//.demand_pattern(junctionDto.getDemand_pattern())
					.emitter_coeff(junctionDto.getEmitter_coeff())
					.ignore_for_geocoded(junctionDto.isIgnore_for_geocoded())
					.required_head(junctionDto.getRequired_head())
					.symbol(junctionDto.getSymbol())
					.zone(junctionDto.getZone())
					.tags(junctionDto.getTags())
					
					.build();
			
			if (index < SAMPLE_SIZE) {
				junctions.add(junction);
				index++;
			}
			allJunctions.add(junction);
					
		}
		
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(junctions);
			log.info("..at saveJunctions, object as Json:  " + objectAsJson); 
		} catch (JsonProcessingException e) {
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
		
		log.info("");
		log.info("Junctions for sensors");
		for (Junction aJunction : allJunctions) {
			if ((aJunction.getName().contains("2949126")) ||
					(aJunction.getName().contains("2949127")) ||
					(aJunction.getName().contains("2949128")) ||
					(aJunction.getName().contains("2949123")) ||
					(aJunction.getName().contains("2949122")) ||
					(aJunction.getName().contains("2949121")) ||
					(aJunction.getName().contains("2949141")) ||
					(aJunction.getName().contains("2929057")) ||
					(aJunction.getName().contains("2929055")) ||
					(aJunction.getName().contains("2929054")) ||
					(aJunction.getName().contains("2949120")) ||
					(aJunction.getName().contains("2846311")) ) {
				printJunctions.add(aJunction);
			}
		}
		
		log.info("Junctions for sensors size: " + printJunctions.size());
		String junctionObjectAsJson;
		try {
			if (printJunctions.size() > 0) {
				junctionObjectAsJson = mapper.writeValueAsString(printJunctions);
				log.info("..at saveJunctions: Sensor junction object as Json:  " + junctionObjectAsJson); 
				log.info(" "); 
				
				createJunctions(network,allJunctions);
			}
			
			log.info("--- Emd of junctions with sensors ---");
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
		log.info("");
		
		return junction;
	}
	
	//Send test junctions
	private  ResponseEntity<String> createJunctions (String network,List<Junction> junctions) {
		
		final String serviceUrl = "/networks/" + network +  "/junctions";
		final String baseUrl = networUrl+serviceUrl;
		
		int postIndex = 0; 
		int stepSize = 100;
		
		if ((junctions == null)|| (junctions.size() < 1))  {
			log.error("..at createJunctions, no junctions aviable:  ");  
			return null;
		}
		URI uri = null;
	    
		ResponseEntity<String> result = null;
		
	    try {
	    	log.info(".. At createJunctions, baseurl:  " + baseUrl);  
	    	
			
			uri = new URI(baseUrl);
		
			restTemplate = new RestTemplate();
			for (Junction junction : junctions) {
				postIndex++;
				HttpEntity<Junction> request = new HttpEntity<>(junction, defineHeaders());
				result = restTemplate.postForEntity(uri, request, String.class); 
				if (postIndex % stepSize == 0) {
					log.info("Pipe: " + postIndex + " send with result: " + result.getStatusCode());  
				}
				
			}
			
		
	    } catch (Exception e) {
	    	log.error("..at createJunctions, Error occured:  "); 
			e.printStackTrace();
			return null;
		}
		
		log.info("Junctions posted with response: " + result.getStatusCode());        
		
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
