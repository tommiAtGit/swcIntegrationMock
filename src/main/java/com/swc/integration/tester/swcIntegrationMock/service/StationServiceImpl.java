package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swc.integration.tester.swcIntegrationMock.model.Station;
import com.swc.integration.tester.swcIntegrationMock.model.web.StationDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StationServiceImpl implements StationService {

	private ObjectMapper mapper = new ObjectMapper();
	private static int SAMPLE_SIZE = 3;
	@Override
	public Station saveStation(List<StationDto> stationDtos) {
		
		
		Station station = null;
		List<Station> stations = new ArrayList<Station>();
		int index = 0;
		
		for (StationDto stationDto : stationDtos) {
			
			station = Station.builder()
					.uuid(stationDto.getUuid())
					.network(stationDto.getNetwork())
					.name(stationDto.getName())
					.description(stationDto.getDescription())
					.settings(stationDto.getSettings())
					//.code(stationDto.getCode())  
					.tags(stationDto.getTags())
					.children(stationDto.getChildren())
				.build();
			if (index < SAMPLE_SIZE) {
				stations.add(station);
				index++;
			}
		}
		
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(stations);
			log.info("..at saveStations, object as Json:  " + objectAsJson); 
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
		
		
		return station;
	}

}
