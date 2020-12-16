package com.swc.integration.tester.swcIntegrationMock.model;





import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

public class Hydrant extends Node {

	
	private double open_time;
	     	
	private double close_time;
	  
	private double max_flow;
	  
	private double min_pressure;
	 
	private double diameter;
              
}