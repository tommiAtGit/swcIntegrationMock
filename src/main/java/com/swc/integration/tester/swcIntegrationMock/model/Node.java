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
public class Node {

	  	private String uuid;
    
	  	private String name;
	  	
        private String description;
       	
	  	private double quality;
       	
       	private NodeSource source;
              
        private Point coordinates;
        
}
