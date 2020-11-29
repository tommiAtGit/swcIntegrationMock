package com.swc.integration.tester.swcIntegrationMock.model;

import java.util.List;

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
public class Reservoir {

	private Node  node;
	
	private String station;
	
	private double head;
           
    private String head_pattern;
    
    private String symbol;
   
    private List<String> tags;
           
}
