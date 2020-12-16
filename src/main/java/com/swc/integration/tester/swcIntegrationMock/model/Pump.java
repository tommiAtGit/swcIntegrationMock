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
public class Pump extends Link{

	//private Link link;
	
	private String station;
    
	private double power;
    
	private String head_curve;
    
	private double speed;
    
	private String speed_pattern;
         
}
