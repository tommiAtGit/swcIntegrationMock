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

import com.swc.integration.tester.swcIntegrationMock.model.Hydrant;
import com.swc.integration.tester.swcIntegrationMock.model.web.HydrantDto;
import com.swc.integration.tester.swcIntegrationMock.service.HydrantService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/networks/{networkID}/hydrants")
@RestController
public class HydrantsController {
	@Autowired
	HydrantService service;

	@PostMapping
	public ResponseEntity<Hydrant> saveHydrant(@Validated @PathVariable("networkID") String networkId,
			@Validated @RequestBody List<HydrantDto> HydrantkDto) {

		if (networkId == null) {
			log.error("..at saveHydrant, network id were null");
		} else {
			log.info("..at saveHydrant, network  id OK! " + networkId);
		}

		log.info("New HYDRANTS added: " + HydrantkDto.size() + " with network id: " + networkId);
		return new ResponseEntity<Hydrant>(service.saveHydrant(networkId, HydrantkDto), HttpStatus.CREATED);

	}
}
