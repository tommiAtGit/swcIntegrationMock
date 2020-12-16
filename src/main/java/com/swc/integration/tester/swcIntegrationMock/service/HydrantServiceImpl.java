package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
	
	@Override
	public Hydrant saveHydrant(List<HydrantDto> hydrantDto) {
		
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
				hydrants.add(hyd);
				index++;
			}
			
		}
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(hydrants);
			log.info("..at saveHydrant, object as Json:  " + objectAsJson); 
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	
}
