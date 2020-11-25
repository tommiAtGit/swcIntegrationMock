package com.swc.integration.tester.swcIntegrationMock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swc.integration.tester.swcIntegrationMock.model.Station;
import com.swc.integration.tester.swcIntegrationMock.model.web.StationDto;
import com.swc.integration.tester.swcIntegrationMock.service.StationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/network/{networkID}/stations")
@RestController
public class StationController {

	@Autowired
	StationService service;
	
	@PostMapping
	public ResponseEntity<Station>saveHousingCooperative( @Validated @RequestBody StationDto stationDto){
		log.info("New station added with name: " + stationDto.getName());
		return new ResponseEntity<Station>(service.saveStation(stationDto),HttpStatus.CREATED);
	
	}
}
