package com.swc.integration.tester.swcIntegrationMock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swc.integration.tester.swcIntegrationMock.model.Area;
import com.swc.integration.tester.swcIntegrationMock.model.web.AreaDto;
import com.swc.integration.tester.swcIntegrationMock.service.AreaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(" /networks/{networkID}/areas")
@RestController
public class AreaController {

	@Autowired
	AreaService service;

	public ResponseEntity<Area> saveAreas(@Validated @PathVariable("networkID") String networkId,
			@Validated @RequestBody List<AreaDto> areaDtos) {

		if (networkId == null) {
			log.error("..at saveAreas, network id were null");
		} else {
			log.info("..at saveAreas, network id OK! " + networkId);
		}

		log.info(".. New DEMANDS added. Number of demands created: " + areaDtos.size());

		return new ResponseEntity<Area>(service.saveNewArea(networkId, areaDtos), HttpStatus.CREATED);
	}

}
