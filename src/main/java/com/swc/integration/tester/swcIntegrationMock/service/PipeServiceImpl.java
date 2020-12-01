package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.List;

import com.swc.integration.tester.swcIntegrationMock.model.Pipe;
import com.swc.integration.tester.swcIntegrationMock.model.web.PipeDto;

public class PipeServiceImpl implements PipeService{

	@Override
	public Pipe savePipe(List<PipeDto> pipeDtos) {
		
		Pipe pipe = null;
		
		for (PipeDto pipeDto : pipeDtos) {
			pipe = Pipe.builder()
					.custom_length(pipeDto.getCustom_length())
					.diameter(pipeDto.getDiameter())
					.lenth(pipeDto.getLenth())
					.material(pipeDto.getMaterial())
					.link(pipeDto.getLink())
					.build();
		}
		// TODO Auto-generated method stub
		return pipe;
	}

}
