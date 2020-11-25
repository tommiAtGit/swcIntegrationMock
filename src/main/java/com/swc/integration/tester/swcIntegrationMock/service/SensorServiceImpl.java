package com.swc.integration.tester.swcIntegrationMock.service;

import org.springframework.stereotype.Service;

import com.swc.integration.tester.swcIntegrationMock.model.Sensor;
import com.swc.integration.tester.swcIntegrationMock.model.web.SensorDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SensorServiceImpl implements SensorService{

	@Override
	public Sensor saveSensor(SensorDto sensorkDto) {
		
		log.info("..Sensor received with following parameters: " +  sensorkDto.getUuid() + " " + sensorkDto.getName() );
		return Sensor.builder()
				.uuid(sensorkDto.getUuid())
				.name(sensorkDto.getName())
				.description(sensorkDto.getDescription())
				.build();
	}

}
