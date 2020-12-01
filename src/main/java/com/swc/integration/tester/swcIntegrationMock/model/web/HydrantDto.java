package com.swc.integration.tester.swcIntegrationMock.model.web;

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
public class HydrantDto {

	private Node node;
	
	private double open_time;
	     	
	private double close_time;
	  
	private double max_flow;
	  
	private double min_pressure;
	 
	private double diameter;
}
