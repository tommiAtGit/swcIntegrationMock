package com.swc.integration.tester.swcIntegrationMock.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swc.integration.tester.swcIntegrationMock.model.Network;
import com.swc.integration.tester.swcIntegrationMock.model.web.NetworkDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NetworkServiceImpl implements NetworkService {

	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public Network saveNetwork(NetworkDto networkDto) {
		
		log.info("..Network received with following parameters: " + networkDto.getUuid() + " " + networkDto.getName() );
	
		Network network =  Network.builder()
				.uuid(networkDto.getUuid())
				.name(networkDto.getName())
				.description(networkDto.getDescription())
				.build();
		
		
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(network);
			log.info("..at saveNetwork, object as Json:  " + objectAsJson); 
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
		
		return network;
	}

}
