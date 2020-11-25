package com.swc.integration.tester.swcIntegrationMock.service;

import com.swc.integration.tester.swcIntegrationMock.model.Station;
import com.swc.integration.tester.swcIntegrationMock.model.web.StationDto;


public interface StationService {
	public Station saveStation(StationDto stationDto);
}
