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

import com.swc.integration.tester.swcIntegrationMock.model.Reservoir;
import com.swc.integration.tester.swcIntegrationMock.model.web.ReservoirDto;
import com.swc.integration.tester.swcIntegrationMock.service.ReservoirService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/networks/{networkID}/stations/{stationId}/reservoir")
@RestController
public class ReservoirController {

	@Autowired
	ReservoirService service;

	@PostMapping
	public ResponseEntity<Reservoir> saveReservoir(@Validated @PathVariable("networkID") String networkId,
			@Validated @PathVariable("stationId") String stationId,
			@Validated @RequestBody List<ReservoirDto> reservoirDtos) {

		if (networkId == null) {
			log.error("..at saveReservoir, network id were null");
		} else {
			log.info("..at saveReservoir, network id OK! " + networkId);
		}

		log.info(".. New RESERVOIR added. Number of reservoirs created: " + reservoirDtos.size());
		return new ResponseEntity<Reservoir>(service.saveReservoir(reservoirDtos), HttpStatus.CREATED);

	}

}
