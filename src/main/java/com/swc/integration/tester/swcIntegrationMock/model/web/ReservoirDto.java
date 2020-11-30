package com.swc.integration.tester.swcIntegrationMock.model.web;

import java.util.List;

import com.swc.integration.tester.swcIntegrationMock.model.Node;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReservoirDto {

	private Node  node;
	
	private String station;
	
	private double head;
           
    private String head_pattern;
    
    private String symbol;
   
    private List<String> tags;
}
