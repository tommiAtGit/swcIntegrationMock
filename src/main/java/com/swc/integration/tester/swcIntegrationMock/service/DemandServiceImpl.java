package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swc.integration.tester.swcIntegrationMock.model.Demand;
import com.swc.integration.tester.swcIntegrationMock.model.web.DemandDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DemandServiceImpl implements DemandService{
	
	private ObjectMapper mapper = new ObjectMapper();
	private static int SAMPLE_SIZE = 3;
	
	
	@Override
	public Demand saveDemand(List<DemandDto> demandDtos) {
		
		Demand demand = null;
		List<Demand> deamnds = new ArrayList<Demand>();
		int index = 0;
		
		for (DemandDto demandDto : demandDtos) {
			demand = Demand.builder()
					.uuid(demandDto.getUuid())
					.network(demandDto.getNetwork())
					.name(demandDto.getName())
					.demand(demandDto.getDemand())
					.demand_pattern(demandDto.getDemand_pattern())
					.category(demandDto.getCategory())
					.parent(demandDto.getParent())
					.address(demandDto.getAddress())
					.lat(demandDto.getLat())
					.lon(demandDto.getLon())
					.alt(demandDto.getAlt())
					.tags(demandDto.getTags())
					.build();
			
			if (index <SAMPLE_SIZE) {
				deamnds.add(demand);
				index++;
			}
			
		}
		
		// Print out sample of pipes as json
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(deamnds);
			log.info("..at saveDemands, object as Json:  " + objectAsJson); 
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
				
		return demand;
	}

}
