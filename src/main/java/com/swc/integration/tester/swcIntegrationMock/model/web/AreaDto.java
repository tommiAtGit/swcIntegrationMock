package com.swc.integration.tester.swcIntegrationMock.model.web;

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
public class AreaDto {
	
	private String uuid;
    
	private  String network;
	          
	private List <String> ext_id;
	          
	private String name;
}
