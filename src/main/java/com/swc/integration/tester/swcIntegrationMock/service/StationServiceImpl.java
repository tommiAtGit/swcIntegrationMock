package com.swc.integration.tester.swcIntegrationMock.service;

import org.springframework.stereotype.Service;

import com.swc.integration.tester.swcIntegrationMock.model.Station;
import com.swc.integration.tester.swcIntegrationMock.model.web.StationDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StationServiceImpl implements StationService {

	@Override
	public Station saveStation(StationDto stationDto) {
		
		log.info("...Station received with following parameters: " +  stationDto.getUuid() + " " + stationDto.getName() );
		return Station.builder()
				.uuid(stationDto.getUuid())
				.name(stationDto.getName())
				.description(stationDto.getDescription())
				.build();
	}

}
