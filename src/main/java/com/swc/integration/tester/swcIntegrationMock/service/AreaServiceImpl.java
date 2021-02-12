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
import com.swc.integration.tester.swcIntegrationMock.model.Area;
import com.swc.integration.tester.swcIntegrationMock.model.web.AreaDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AreaServiceImpl implements AreaService {

	@Value("${swc.network.url}")
	private String networUrl;
	 
	@Value("${swc.network.token}")
	private String networkApiToken; 

	
	@Value("${swc.network.sendflag}")
	private String sendFlag;
	
	private ObjectMapper mapper = new ObjectMapper();
	private static RestTemplate restTemplate;
	
	@Override
	public Area saveNewArea(String networkId, List<AreaDto> areaDtos) {
		Area area = null;
		
		
		List<Area> areas = new ArrayList<Area>();
		for (AreaDto areaDto : areaDtos) {
			area = Area.builder()
					.uuid(areaDto.getUuid())
					.network(areaDto.getNetwork())
					.ext_id(areaDto.getExt_id())
					.name(areaDto.getName())
					.build();
			areas.add(area);
		}
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(areas);
			log.info("..at newArea, object as Json:  " + objectAsJson); 
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
		if (sendFlag.equals("TRUE")) {
			log.info(" ");
			log.info("+ Send Areas + ");
			createTestArea(networkId, areas);
		}
		
		return area;
	}
	
	private  ResponseEntity<String> createTestArea (String networkId, List<Area> areas) {
		final String serviceUrl = "/networks/" + networkId +  "/areas";
		final String baseUrl = networUrl+serviceUrl;
		int index = 0;
		int stepSize = 100;
		
		log.info("++ Start of Area post: ++ " + LocalDateTime.now()); 
		if ((areas == null)|| (areas.size() < 1))  {
			log.error("..at createTestPipes, no pipes aviable:  ");  
			return null;
		}
		URI uri = null;
	    
		ResponseEntity<String> result = null;
		
	    try {
	    	log.info(".. At createTestPipes, baseurl:  " + baseUrl);  
	    	
			
			uri = new URI(baseUrl);
		
			restTemplate = new RestTemplate();
			for (Area area : areas) {
				index++;
				HttpEntity<Area> request = new HttpEntity<>(area, defineHeaders());
				
				result = restTemplate.postForEntity(uri, request, String.class);
				if (index % stepSize == 0) {
					log.info("Area: " + index + " send with result: " + result.getStatusCode());	
				}
				  
			}
			
		
	    } catch (Exception e) {
	    	log.error("..at createTestArea, Error occured:  "); 
			e.printStackTrace();
			return null;
		}
		
		log.info("Area posted with response: " + result.getStatusCode());        
		
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
