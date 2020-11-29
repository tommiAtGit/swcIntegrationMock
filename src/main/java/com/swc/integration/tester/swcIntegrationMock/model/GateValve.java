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

public class GateValve {
  
	private String uuid;
  
	private String network;
  
	private String name;
  
	private double change_time;
  
	private double change_back_time;
      
	private Boolean closed;
 
	private double lat; // min: -90.0, max: 90 

	private double lon; // minn: -180, 180

	private double alt;  

	private List<String> ext_ids;

	private List<String> tags;

	private List<String> zones;
       
}
