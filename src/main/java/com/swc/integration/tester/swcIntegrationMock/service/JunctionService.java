package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.List;

import com.swc.integration.tester.swcIntegrationMock.model.Junction;
import com.swc.integration.tester.swcIntegrationMock.model.web.JunctionDto;

public interface JunctionService {

	Junction saveJunction(List<JunctionDto> junctions, String networkId);
}
