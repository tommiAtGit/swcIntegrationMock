package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swc.integration.tester.swcIntegrationMock.model.Reservoir;
import com.swc.integration.tester.swcIntegrationMock.model.web.ReservoirDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReserviorServiceImpl implements ReservoirService{

	@Override
	public Reservoir saveReservoir(List<ReservoirDto> reservoirDto) {
		log.info(".. At saveReservoir ");
		// TODO Auto-generated method stub
		return null;
	}

}
