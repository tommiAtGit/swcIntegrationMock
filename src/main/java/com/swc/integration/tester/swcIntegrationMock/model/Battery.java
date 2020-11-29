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


public class Battery {
	

	private Link link;
        
	private String battery_type;
              
	private String algorithm;
              
	private Integer max_concurrent_pumps;
     
	private double flow_step;
     
	private  double head_step;
	
	private List<String> ext_ids;
      
	private List<String> tags;
      
	private List<String> zones;
      
	private List<String> pumps;
            
}
