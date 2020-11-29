package com.swc.integration.tester.swcIntegrationMock.model;

import java.util.UUID;


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
public class NodeSource {

	 private SourceEnum sourceType;
	 
	 private double strength;
     
     private UUID strength_pattern;
}
