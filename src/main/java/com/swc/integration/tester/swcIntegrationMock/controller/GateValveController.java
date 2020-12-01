package com.swc.integration.tester.swcIntegrationMock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swc.integration.tester.swcIntegrationMock.model.GateValve;
import com.swc.integration.tester.swcIntegrationMock.model.web.GateValveDto;
import com.swc.integration.tester.swcIntegrationMock.service.GatevalveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/networks/{networkID}/gatevalves")
@RestController
public class GateValveController {
	@Autowired
	GatevalveService service;
	
	@PostMapping
	public ResponseEntity<GateValve>saveNetwork(@Validated @PathVariable("networkID") String networkId,
												@Validated @RequestBody GateValveDto gatevalvekDto){
		log.info("New Network added with uuid: " +gatevalvekDto.getUuid() + " and name: " + gatevalvekDto.getName());
		return new ResponseEntity<GateValve>(service.saveGateValve(gatevalvekDto),HttpStatus.CREATED);
	
	}
}
