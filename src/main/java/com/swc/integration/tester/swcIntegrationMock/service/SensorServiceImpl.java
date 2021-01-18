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
import com.swc.integration.tester.swcIntegrationMock.model.FlowSensor;
import com.swc.integration.tester.swcIntegrationMock.model.PressureSensor;
import com.swc.integration.tester.swcIntegrationMock.model.Sensor;
import com.swc.integration.tester.swcIntegrationMock.model.WaterLevelSenor;
import com.swc.integration.tester.swcIntegrationMock.model.web.SensorDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SensorServiceImpl implements SensorService{

	private ObjectMapper mapper = new ObjectMapper();
	//private static int SAMPLE_SIZE = 3;
	private static RestTemplate restTemplate;
	@Value("${swc.network.url}")
	private String networUrl;
	 
	@Value("${swc.network.token}")
	private String networkApiToken; 

	@Override
	public Sensor saveSensor(String networkId, List<SensorDto> sensorkDtos) {
		
		Sensor sensor = null;
		List<Sensor> sensors = new ArrayList<Sensor>();
		//List<Sensor> testSensors = new ArrayList<Sensor>();
		
		
		for (SensorDto sensorDto : sensorkDtos) {
				
			switch(sensorDto.getSensor_type()) {
			case FLOW:
				FlowSensor flowSensor = FlowSensor.builder()
				.id(sensorDto.getUuid().toString())
				.ext_id(sensorDto.getExt_id())
				.sensor_id(sensorDto.getSensor_id())
				.sensor_type(sensorDto.getSensor_type())
				.position(sensorDto.getPosition())
				.parent(sensorDto.getParent())
				.reverse(sensorDto.getReverse())
				.build();
				sensors.add(flowSensor);
			case LEVEL:
				WaterLevelSenor waterLevelSenor = WaterLevelSenor.builder()
				.id(sensorDto.getUuid().toString())
				.ext_id(sensorDto.getExt_id())
				.sensor_id(sensorDto.getSensor_id())
				.sensor_type(sensorDto.getSensor_type())
				.position(sensorDto.getPosition())
				.parent(sensorDto.getParent())
				.vertical_position(sensorDto.getVertical_position())
				.build();
				sensors.add(waterLevelSenor);

			case PRESSURE:
				PressureSensor pressureSensor = PressureSensor.builder()
				.id(sensorDto.getUuid().toString())
				.ext_id(sensorDto.getExt_id())
				.sensor_id(sensorDto.getSensor_id())
				.sensor_type(sensorDto.getSensor_type())
				.position(sensorDto.getPosition())
				.parent(sensorDto.getParent())
				.offset_error(sensorDto.getOffset_error())
				.build();
				sensors.add(pressureSensor);
				
			}
			
		}
		
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(sensors);
			log.info("..at saveSensors, object as Json:  " + objectAsJson); 
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
		
//		for (Sensor s : sensors) {
//			if ((s.getExt_id().contains("2949126")) || (s.getExt_id().contains("2846311")) ) {
//				testSensors.add(s);
//			}
//			
//		}
		log.info("  "); 
		try {
//			AsJson = mapper.writeValueAsString(testSensors);
//			log.info("..at saveSensors, object as Json:  " + AsJson); 
			log.info("+ Send sensors + ");
			createSensors(networkId,sensors);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
		log.info("  "); 
		
		return sensor;
		
			
	}
	//Send test junctions
		private  ResponseEntity<String> createSensors (String network,List<Sensor> sensors) {
			
			final String serviceUrl = "/networks/" + network +  "/sensors";
			final String baseUrl = networUrl+serviceUrl;
			
			int postIndex = 0; 
			int printStepSize = 2;
			
			log.info("++ Start of Sensor post: " + LocalDateTime.now() + "++");    
			if ((sensors == null)|| (sensors.size() < 1))  {
				log.error("..at createSensors, no sensors aviable:  ");  
				return null;
			}
			URI uri = null;
		    
			ResponseEntity<String> result = null;
			
		    try {
		    	log.info(".. At createSensors, baseurl:  " + baseUrl);  
		    	
				
				uri = new URI(baseUrl);
			
				restTemplate = new RestTemplate();
				for (Sensor sensor : sensors) {
					postIndex++;
					HttpEntity<Sensor> request = new HttpEntity<>(sensor, defineHeaders());
					result = restTemplate.postForEntity(uri, request, String.class); 
					if (postIndex % printStepSize == 0) {
						log.info("Sensor: " + postIndex + " send with result: " + result.getStatusCode());  
					}
					
				}
				
			
		    } catch (Exception e) {
		    	log.error("..at createSensors, Error occured:  "); 
				e.printStackTrace();
				return null;
			}
			
			log.info("Sensors posted with response: " + result.getStatusCode());       
			
			log.info("++ End of Sensor post: " + LocalDateTime.now() + "++");
			
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
