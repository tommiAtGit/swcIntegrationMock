package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.List;

import com.swc.integration.tester.swcIntegrationMock.model.Area;
import com.swc.integration.tester.swcIntegrationMock.model.web.AreaDto;

public interface AreaService {

	Area saveNewArea(String networkId, List<AreaDto> newArea);
}
