package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.swc.integration.tester.swcIntegrationMock.model.GateValve;
import com.swc.integration.tester.swcIntegrationMock.model.web.GateValveDto;

public interface GatevalveService {
	GateValve saveGateValve(String networkId, List<GateValveDto> gatevalveDtos);

	GateValve updateGateValve(String networkId, String gateValveId, GateValveDto gatevalveDto);

}
