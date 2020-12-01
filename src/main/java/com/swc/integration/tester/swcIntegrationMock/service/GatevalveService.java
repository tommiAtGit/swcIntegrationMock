package com.swc.integration.tester.swcIntegrationMock.service;

import com.swc.integration.tester.swcIntegrationMock.model.GateValve;
import com.swc.integration.tester.swcIntegrationMock.model.web.GateValveDto;

public interface GatevalveService {
	public GateValve saveGateValve(GateValveDto gatevalveDto);
}
