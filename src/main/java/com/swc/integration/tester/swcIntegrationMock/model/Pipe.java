package com.swc.integration.tester.swcIntegrationMock.model;

import java.util.List;

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

public class Pipe extends Link{

	
	private double lenth;
		            
	private double diameter;
		              
	private double roughness;
		            
	private double minor_loss;
		            
	private String  material;
		            
	private double custom_length;
		              
	private Integer year;
		              
	private Boolean zone_limit;
		             
	private List<String> zones;
		             
	private List<String> tags;
		           
	private List<String> ext_ids;
	             
}
