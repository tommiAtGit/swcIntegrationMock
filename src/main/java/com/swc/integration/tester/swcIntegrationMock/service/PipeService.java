package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.List;

import com.swc.integration.tester.swcIntegrationMock.model.Pipe;
import com.swc.integration.tester.swcIntegrationMock.model.web.PipeDto;

public interface PipeService {

	public Pipe savePipe(String networkId, List<PipeDto> pipeDto);
}
