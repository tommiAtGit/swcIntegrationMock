package com.swc.integration.tester.swcIntegrationMock.service;

import com.swc.integration.tester.swcIntegrationMock.model.Network;
import com.swc.integration.tester.swcIntegrationMock.model.web.NetworkDto;

public interface NetworkService {

	public Network saveNetwork(NetworkDto networkDto);
}
