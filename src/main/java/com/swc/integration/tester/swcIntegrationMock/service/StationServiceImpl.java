package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swc.integration.tester.swcIntegrationMock.model.Station;
import com.swc.integration.tester.swcIntegrationMock.model.web.StationDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StationServiceImpl implements StationService {

	@Override
	public Station saveStation(List<StationDto> stationDtos) {
		
		
		Station station = null;
		for (StationDto stationDto : stationDtos) {
			
			log.info("...Station received with following parameters: " +  stationDto.getUuid() + " Name " + stationDto.getName()  + " Network " + stationDto.getNetwork());
			
			station = Station.builder()
				.uuid(stationDto.getUuid())
				.name(stationDto.getName())
				.description(stationDto.getDescription())
				.build();
		}
		
		
		return station;
	}

}
