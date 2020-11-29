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
public class Tank {

	private Node node;
	
	private String station;
	 
	private double elevation;
	    
	private double init_level;
	    
	private double min_level;
	    
	private double max_level;
	    
	private double diameter;
	    
	private double min_volume;
	    
	private String vol_curve;
	   
	private Boolean overflow;
	   
	private MixingModel mixing;
	    
	private  String symbol;
	  
	private  List<String> tags;
	    
	private List<String> zones;
	    
}
