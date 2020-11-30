package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.List;

import com.swc.integration.tester.swcIntegrationMock.model.Reservoir;
import com.swc.integration.tester.swcIntegrationMock.model.web.ReservoirDto;

public interface ReservoirService {

	public Reservoir saveReservoir(List<ReservoirDto> reservoirDto);
}
