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

import com.swc.integration.tester.swcIntegrationMock.model.Station;
import com.swc.integration.tester.swcIntegrationMock.model.web.StationDto;
import com.swc.integration.tester.swcIntegrationMock.service.StationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/networks/{networkID}/stations")
@RestController
public class StationController {

	@Autowired
	StationService service;

	@PostMapping
	public ResponseEntity<Station> saveStations(@Validated @PathVariable("networkID") String networkId,
			@Validated @RequestBody List<StationDto> stationDtos) {

		if (networkId == null) {
			log.error("..at saveStations, network id were NULL");
		} else {
			log.info("..at saveStations, network id OK! " + networkId);
		}

		log.info("New STATIONS added. Number of stations created:: " + stationDtos.size());
		return new ResponseEntity<Station>(service.saveStation(stationDtos), HttpStatus.CREATED);

	}
}
