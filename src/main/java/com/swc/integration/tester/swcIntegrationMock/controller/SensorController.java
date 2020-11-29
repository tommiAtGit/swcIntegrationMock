package com.swc.integration.tester.swcIntegrationMock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swc.integration.tester.swcIntegrationMock.model.Sensor;
import com.swc.integration.tester.swcIntegrationMock.model.web.SensorDto;
import com.swc.integration.tester.swcIntegrationMock.service.SensorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/networks/{networkID}/sensors")
@RestController
public class SensorController {

	@Autowired
	SensorService service;
	
	
	
	@PostMapping
	public ResponseEntity<Sensor>saveSensors( @Validated @PathVariable("networkID") String networkId, @Validated @RequestBody List<SensorDto> sensorDtos){
		
		if (networkId == null) {
			log.error("..at saveSensors, network id were null");
		}
		else {
			log.info("..at saveSensors, network id OK! " + networkId );
		}
		
		log.info(".. New sensors added. Number of sensors created: " + sensorDtos.size());
		return new ResponseEntity<Sensor>(service.saveSensor(sensorDtos),HttpStatus.CREATED);
	
	}
}
