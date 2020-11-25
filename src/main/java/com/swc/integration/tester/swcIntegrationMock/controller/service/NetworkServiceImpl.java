package com.swc.integration.tester.swcIntegrationMock.controller.service;

import org.springframework.stereotype.Service;

import com.swc.integration.tester.swcIntegrationMock.model.Network;
import com.swc.integration.tester.swcIntegrationMock.model.web.NetworkDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NetworkServiceImpl implements NetworkService {

	@Override
	public Network saveNetwork(NetworkDto networkDto) {
		
		log.info("..Network received with following parameters: " + networkDto.getUuid() + " " +networkDto.getName() );
		return Network.builder()
				.uuid(networkDto.getUuid())
				.name(networkDto.getName())
				.description(networkDto.getDescription())
				.build();
	}

}
