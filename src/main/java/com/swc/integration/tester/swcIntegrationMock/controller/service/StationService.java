package com.swc.integration.tester.swcIntegrationMock.controller.service;

import com.swc.integration.tester.swcIntegrationMock.model.Station;
import com.swc.integration.tester.swcIntegrationMock.model.web.StationDto;


public interface StationService {
	public Station saveStation(StationDto stationDto);
}
