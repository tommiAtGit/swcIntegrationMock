package com.swc.integration.tester.swcIntegrationMock.model;



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
public class Pump {

	private Link link;
	
	private String station;
    
	private double power;
    
	private String head_curve;
    
	private double speed;
    
	private String speed_pattern;
         
}
