package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swc.integration.tester.swcIntegrationMock.model.Sensor;
import com.swc.integration.tester.swcIntegrationMock.model.web.SensorDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SensorServiceImpl implements SensorService{

	@Override
	public Sensor saveSensor(List<SensorDto> sensorkDtos) {
		
		Sensor sensor = null;
		for (SensorDto sensorDto : sensorkDtos) {
			log.info("..Sensor received with following parameters: " +  sensorDto.getUuid() + " name: " + sensorDto.getName() + "lat: " + sensorDto.getPosition().getLat() + " lon: " + sensorDto.getPosition().getLon() + " alt: " + sensorDto.getPosition().getAlt());	
			sensor = Sensor.builder()
					.uuid(sensorDto.getUuid())
					.name(sensorDto.getName())
					.sensor_type(sensorDto.getSensor_type())
					.position(sensorDto.getPosition())
					.build();
		}
		return sensor;
		
			
	}

}
