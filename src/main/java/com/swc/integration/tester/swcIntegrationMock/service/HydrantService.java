package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.List;

import com.swc.integration.tester.swcIntegrationMock.model.Hydrant;
import com.swc.integration.tester.swcIntegrationMock.model.web.HydrantDto;

public interface HydrantService {

	public Hydrant saveHydrant(String network, List<HydrantDto> hydrantDto);
}
