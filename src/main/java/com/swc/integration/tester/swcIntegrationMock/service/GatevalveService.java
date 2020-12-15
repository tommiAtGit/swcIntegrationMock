package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.List;

import com.swc.integration.tester.swcIntegrationMock.model.GateValve;
import com.swc.integration.tester.swcIntegrationMock.model.web.GateValveDto;

public interface GatevalveService {
	public GateValve saveGateValve(List<GateValveDto> gatevalveDtos);
}
