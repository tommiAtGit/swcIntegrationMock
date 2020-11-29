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
public class Link {

	private String uuid;
    
	private String name;
    
	private String start;
    
	private String  end;
    
	private List<Vertices> verties;
    
	private double leakage_coeff1;
    
	private double leakage_coeff2;
    
	private LinkStatus link_status;
    
	private ExtraFields extra_fields;
   
}
