package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swc.integration.tester.swcIntegrationMock.model.FlowSensor;
import com.swc.integration.tester.swcIntegrationMock.model.PressureSensor;
import com.swc.integration.tester.swcIntegrationMock.model.Sensor;
import com.swc.integration.tester.swcIntegrationMock.model.WaterLevelSenor;
import com.swc.integration.tester.swcIntegrationMock.model.web.SensorDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SensorServiceImpl implements SensorService{

	private ObjectMapper mapper = new ObjectMapper();
	private static int SAMPLE_SIZE = 3;
	
	@Override
	public Sensor saveSensor(List<SensorDto> sensorkDtos) {
		
		Sensor sensor = null;
		List<Sensor> sensors = new ArrayList<Sensor>();
		int index = 0;
		
		for (SensorDto sensorDto : sensorkDtos) {
				
			switch(sensorDto.getSensor_type()) {
			case FLOW:
				FlowSensor flowSensor = FlowSensor.builder()
				.id(sensorDto.getUuid().toString())
				.ext_id(sensorDto.getExt_id())
				.sensor_id(sensorDto.getName())
				.sensor_type(sensorDto.getSensor_type())
				.position(sensorDto.getPosition())
				.parent(sensorDto.getParent())
				.reverse(sensorDto.getReverse())
				.build();
				sensors.add(flowSensor);
			case LEVEL:
				WaterLevelSenor waterLevelSenor = WaterLevelSenor.builder()
				.id(sensorDto.getUuid().toString())
				.ext_id(sensorDto.getExt_id())
				.sensor_id(sensorDto.getName())
				.sensor_type(sensorDto.getSensor_type())
				.position(sensorDto.getPosition())
				.parent(sensorDto.getParent())
				.vertical_position(sensorDto.getVertical_position())
				.build();
				sensors.add(waterLevelSenor);

			case PRESSURE:
				PressureSensor pressureSensor = PressureSensor.builder()
				.id(sensorDto.getUuid().toString())
				.ext_id(sensorDto.getExt_id())
				.sensor_id(sensorDto.getName())
				.sensor_type(sensorDto.getSensor_type())
				.position(sensorDto.getPosition())
				.parent(sensorDto.getParent())
				.offset_error(sensorDto.getOffset_error())
				.build();
				sensors.add(pressureSensor);
				
			}
			
			
			
		}
		
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(sensors);
			log.info("..at createStations, object as Json:  " + objectAsJson); 
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
		
		
		return sensor;
		
			
	}

}
