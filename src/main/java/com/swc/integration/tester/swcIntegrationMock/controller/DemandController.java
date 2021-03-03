package com.swc.integration.tester.swcIntegrationMock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swc.integration.tester.swcIntegrationMock.model.Demand;
import com.swc.integration.tester.swcIntegrationMock.model.GateValve;
import com.swc.integration.tester.swcIntegrationMock.model.web.DemandDto;
import com.swc.integration.tester.swcIntegrationMock.model.web.GateValveDto;
import com.swc.integration.tester.swcIntegrationMock.service.DemandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/networks/{networkID}/demands")
@RestController
public class DemandController {
	@Autowired
	DemandService service;

	@PostMapping
	public ResponseEntity<Demand> saveDemands(@Validated @PathVariable("networkID") String networkId,
			@Validated @RequestBody List<DemandDto> demandDtos) {

		if (networkId == null) {
			log.error("..at saveDemands, network id were null");
		} else {
			log.info("..at saveDemands, network id OK! " + networkId);
		}

		log.info(".. New DEMANDS added. Number of demands created: " + demandDtos.size());

		return new ResponseEntity<Demand>(service.saveDemand(networkId, demandDtos), HttpStatus.CREATED);

	}

	@PutMapping("/{demandId}")
	public ResponseEntity<Demand> updateDemand(@Validated @PathVariable("networkID") String networkId,
			@Validated @PathVariable("demandId") String demandId, @Validated @RequestBody DemandDto demandDto) {

		if ((networkId == null) || (demandId == null)) {
			log.error("..at updateDemand, network id or demand id were null");
		} else {
			log.info("..at updateDemand, network id OK! " + networkId + " gatevalve id OK! " + demandId);
		}

		return new ResponseEntity<Demand>(service.updateDemand(networkId, demandId, demandDto), HttpStatus.CREATED);

	}
}