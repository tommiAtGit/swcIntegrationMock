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
public class Valve {

	private Link link;
	
	private String station;
	
	private double diameter;
	
	private ValveTypeEnum valve_type;
	
	private double minor_loss;
	
	private double pressure;
	
	private String head_loss_curve;
	
	private double loss;
	              
}
