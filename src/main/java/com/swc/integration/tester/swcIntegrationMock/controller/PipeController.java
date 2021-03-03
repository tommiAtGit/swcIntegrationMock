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

import com.swc.integration.tester.swcIntegrationMock.model.Pipe;
import com.swc.integration.tester.swcIntegrationMock.model.web.PipeDto;
import com.swc.integration.tester.swcIntegrationMock.service.PipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/networks/{networkID}/pipes")
@RestController
public class PipeController {

	@Autowired
	PipeService service;

	@PostMapping
	public ResponseEntity<Pipe> savePipes(@Validated @PathVariable("networkID") String networkId,
			@Validated @RequestBody List<PipeDto> pipeDtos) {

		if (networkId == null) {
			log.error("..at savePipes, network id were null");
		} else {
			log.info("..at savePipes, network id OK! " + networkId);
		}

		log.info(".. New PIPES added. Number of pipes created: " + pipeDtos.size());
		return new ResponseEntity<Pipe>(service.savePipe(networkId, pipeDtos), HttpStatus.CREATED);

	}
}
