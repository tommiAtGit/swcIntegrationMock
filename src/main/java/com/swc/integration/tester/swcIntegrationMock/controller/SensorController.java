package com.swc.integration.tester.swcIntegrationMock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/network/{networkID}/sensors")
@RestController
public class SensorController {

	@Autowired
	SensorService service;
	
	
	
	@PostMapping
	public ResponseEntity<Sensor>saveNetwork( @Validated @RequestBody SensorDto sensorDto){
		log.info(".. New sensor added with name: " + sensorDto.getName());
		return new ResponseEntity<Sensor>(service.saveSensor(sensorDto),HttpStatus.CREATED);
	
	}
}
