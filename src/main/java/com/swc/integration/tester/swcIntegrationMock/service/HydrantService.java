package com.swc.integration.tester.swcIntegrationMock.service;

import com.swc.integration.tester.swcIntegrationMock.model.Hydrant;
import com.swc.integration.tester.swcIntegrationMock.model.web.HydrantDto;

public interface HydrantService {

	public Hydrant saveHydrant(HydrantDto hydrantDto);
}
