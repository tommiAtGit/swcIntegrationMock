package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swc.integration.tester.swcIntegrationMock.model.Junction;
import com.swc.integration.tester.swcIntegrationMock.model.web.JunctionDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JunctionServiceImpl implements JunctionService {

	private ObjectMapper mapper = new ObjectMapper();
	private static int SAMPLE_SIZE = 3;
	
	@Override
	public Junction saveJunction(List<JunctionDto> junctionDtos) {
		Junction junction = null;
		List<Junction> junctions = new ArrayList<Junction>();
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
					
		}
		
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(junctions);
			log.info("..at saveJunctions, object as Json:  " + objectAsJson); 
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
		
		return junction;
	}

	
}
