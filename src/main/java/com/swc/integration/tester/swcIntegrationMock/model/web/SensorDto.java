package com.swc.integration.tester.swcIntegrationMock.model.web;

import java.util.List;
import java.util.UUID;

import com.swc.integration.tester.swcIntegrationMock.model.Point;
import com.swc.integration.tester.swcIntegrationMock.model.SensorTypeEnum;

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
public class SensorDto {

	private UUID  uuid;
	
	private String sensor_id;
    
	private String  ext_id;
   	
	private String name;
    
	private SensorTypeEnum sensor_type;
    
	private Point position;
    
	private String parent;
	
	private double offset_error;
	
	private double vertical_position;
	
	private String reverse;
}
