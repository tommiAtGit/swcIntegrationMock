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

import com.swc.integration.tester.swcIntegrationMock.model.Demand;
import com.swc.integration.tester.swcIntegrationMock.model.web.DemandDto;
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
												@Validated @RequestBody List<DemandDto> demandDtos){
		
		if (networkId == null) {
			log.error("..at saveDemands, network id were null");
		}
		else {
			log.info("..at saveDemands, network id OK! " + networkId );
		}
		
		log.info(".. New DEMANDS added. Number of demands created: " + demandDtos.size());
		
		
		return new ResponseEntity<Demand>(service.saveDemand(demandDtos),HttpStatus.CREATED);
	
	}	
}