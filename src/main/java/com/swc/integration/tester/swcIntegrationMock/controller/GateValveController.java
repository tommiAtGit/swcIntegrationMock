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
	public ResponseEntity<GateValve>saveGateValves(@Validated @PathVariable("networkID") String networkId,
												@Validated @RequestBody List<GateValveDto> gatevalvekDto){
		
		if (networkId == null) {
			log.error("..at saveGateValves, network id were null");
		}
		else {
			log.info("..at saveGateValves, network id OK! " + networkId );
		}
		
		log.info(".. New GATEVALVES added. Number of gate valves created: " + gatevalvekDto.size());
		
		
		return new ResponseEntity<GateValve>(service.saveGateValve(networkId, gatevalvekDto),HttpStatus.CREATED);
	
	}
	
	@PutMapping("/{gatevalveId}")
	public ResponseEntity<GateValve> updateGaveValve(@Validated @PathVariable("networkID") String networkId,
													 @Validated @PathVariable("gatevalveId") String gatevalveId,
													 @Validated @RequestBody GateValveDto gatevalvekDto){
		
		if ((networkId == null) || (gatevalveId == null)) {
			log.error("..at updateGaveValve, network id or gatevalve id were null");
		}
		else 
		{
			log.info("..at updateGaveValve, network id OK! " + networkId + " gatevalve id OK! " + gatevalveId );
		}
		
		return null;
		
	}
	
	
}
