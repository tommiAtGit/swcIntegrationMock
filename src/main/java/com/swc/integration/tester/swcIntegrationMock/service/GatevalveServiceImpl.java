package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swc.integration.tester.swcIntegrationMock.model.GateValve;
import com.swc.integration.tester.swcIntegrationMock.model.web.GateValveDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GatevalveServiceImpl implements GatevalveService {

	private ObjectMapper mapper = new ObjectMapper();
	private static int SAMPLE_SIZE = 3;
	
	@Override
	public GateValve saveGateValve(List<GateValveDto>  gatevalveDtos) {
		
		GateValve gateValve = null;
		List<GateValve> gateValves = new ArrayList<GateValve>();
		int index = 0;
		
		for (GateValveDto gatevalveDto : gatevalveDtos) {
			
			gateValve = GateValve.builder()
					.uuid(gatevalveDto.getUuid())
					.network(gatevalveDto.getNetwork())
					.name(gatevalveDto.getName())
					.change_time(gatevalveDto.getChange_time())
					.change_back_time(gatevalveDto.getChange_back_time())
					.closed(gatevalveDto.getClosed())
					.lat(gatevalveDto.getLat()) 
					.lon(gatevalveDto.getLon())
					.alt(gatevalveDto.getAlt())  
					.ext_ids(gatevalveDto.getExt_ids())
					.tags(gatevalveDto.getTags())
					.zones(gatevalveDto.getZones())
			
					.build();
			if (index <SAMPLE_SIZE) {
				gateValves.add(gateValve);
				index++;
			}
		}
		// Print out sample of pipes as json
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(gateValves);
			log.info("..at createStations, object as Json:  " + objectAsJson); 
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return gateValve;
		
	}

}
