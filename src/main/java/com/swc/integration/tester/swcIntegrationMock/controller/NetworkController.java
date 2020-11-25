package com.swc.integration.tester.swcIntegrationMock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swc.integration.tester.swcIntegrationMock.model.Network;
import com.swc.integration.tester.swcIntegrationMock.model.web.NetworkDto;
import com.swc.integration.tester.swcIntegrationMock.service.NetworkService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/network")
@RestController
public class NetworkController {


		@Autowired
		NetworkService service;
		
		@PostMapping
		public ResponseEntity<Network>saveNetwork( @Validated @RequestBody NetworkDto networkDto){
			log.info("New Network added with name: " + networkDto.getName());
			return new ResponseEntity<Network>(service.saveNetwork(networkDto),HttpStatus.CREATED);
		
		}
}
