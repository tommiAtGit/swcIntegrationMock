package com.swc.integration.tester.swcIntegrationMock.model.web;

import java.util.List;

import com.swc.integration.tester.swcIntegrationMock.model.Link;
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
public class PipeDto {

	private Link link;
	
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
