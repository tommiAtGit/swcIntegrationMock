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

import com.swc.integration.tester.swcIntegrationMock.model.Junction;
import com.swc.integration.tester.swcIntegrationMock.model.web.JunctionDto;
import com.swc.integration.tester.swcIntegrationMock.service.JunctionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/networks/{networkID}/junctions")
@RestController
public class JunctionController {

	@Autowired
	JunctionService service;

	@PostMapping
	public ResponseEntity<Junction> saveJunctions(@Validated @PathVariable("networkID") String networkId,
			@Validated @RequestBody List<JunctionDto> junctionsDto) {

		if (networkId == null) {
			log.error("..at saveJunctions, network id were null");
		} else {
			log.info("..at saveJunctions, network id OK! " + networkId);
		}

		log.info(".. New JUNCTIONS added. Number of junctions created: " + junctionsDto.size());
		return new ResponseEntity<Junction>(service.saveJunction(junctionsDto, networkId), HttpStatus.CREATED);

	}
}
