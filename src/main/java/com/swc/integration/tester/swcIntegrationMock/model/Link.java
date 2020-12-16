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

public abstract class Link {

	private String uuid;
    
	private String name;
    
	private String start;
    
	private String  end;
    
	private List<Vertices> vertices;
    
	private double leakage_coeff1;
    
	private double leakage_coeff2;
    
	//private LinkStatus link_status;
    
	private LinkStatusEnum status;
	
	//private double setting;
	
	private ExtraFields extra_fields;
	
   
}
