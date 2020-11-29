package com.swc.integration.tester.swcIntegrationMock.model;

import java.util.List;
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
public class Sensor {

private UUID  uuid;
    
	private List<String>  ext_id;
   	
	private String name;
    
	private SensorTypeEnum sensor_type;
    
	private Point position;
    
	private UUID parent;
	
	private double offset_error;
	
	private double vertical_position;
	
	private String reverse;
}
