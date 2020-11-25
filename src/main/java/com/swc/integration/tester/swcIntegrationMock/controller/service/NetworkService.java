package com.swc.integration.tester.swcIntegrationMock.controller.service;

import com.swc.integration.tester.swcIntegrationMock.model.Network;
import com.swc.integration.tester.swcIntegrationMock.model.web.NetworkDto;

public interface NetworkService {

	public Network saveNetwork(NetworkDto networkDto);
}
