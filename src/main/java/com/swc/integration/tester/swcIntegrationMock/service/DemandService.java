package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.List;

import com.swc.integration.tester.swcIntegrationMock.model.Demand;
import com.swc.integration.tester.swcIntegrationMock.model.web.DemandDto;

public interface DemandService {

	public Demand saveDemand(String networkId, List<DemandDto> demandDtos);

	public Demand updateDemand(String network, String demandId, DemandDto demandDto);
}
