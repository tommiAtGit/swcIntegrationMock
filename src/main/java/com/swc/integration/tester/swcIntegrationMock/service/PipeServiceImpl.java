package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swc.integration.tester.swcIntegrationMock.model.Pipe;
import com.swc.integration.tester.swcIntegrationMock.model.web.PipeDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PipeServiceImpl implements PipeService{

	private ObjectMapper mapper = new ObjectMapper();
	private static int SAMPLE_SIZE = 3;
	
	@Override
	public Pipe savePipe(List<PipeDto> pipeDtos) {
		
		Pipe pipe = null;
		List<Pipe> pipes = new ArrayList<Pipe>();
		int index = 0;
		
		for (PipeDto pipeDto : pipeDtos) {
			pipe = Pipe.builder()
					.uuid(pipeDto.getUuid())
					.name(pipeDto.getName())
					.start(pipeDto.getStart())
					.end(pipeDto.getEnd())
					.vertices(pipeDto.getVertices())
					.leakage_coeff1(pipeDto.getLeakage_coeff1())
					.leakage_coeff2(pipeDto.getLeakage_coeff2())
					.status(pipeDto.getStatus())
					.extra_fields(pipeDto.getExtra_fields())
					.custom_length(pipeDto.getCustom_length())
					.diameter(pipeDto.getDiameter())
					.length(pipeDto.getLength())
					.material(pipeDto.getMaterial())
					.year(pipeDto.getYear())
					.zones(pipeDto.getZones())
					.tags(pipeDto.getTags())
					.ext_ids(pipeDto.getExt_ids())
					.build();
			if (index < SAMPLE_SIZE) {
				pipes.add(pipe);
				index++;
			}
		}
		// Print out sample of pipes as json
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(pipes);
			log.info("..at savePipes, object as Json:  " + objectAsJson); 
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return pipe;
	}

}
