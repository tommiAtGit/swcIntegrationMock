package com.swc.integration.tester.swcIntegrationMock.model;




import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Sensor {

	private String  uuid;
    
	private String  ext_id;
   	
	private String sensor_id;
    
	private SensorTypeEnum sensor_type;
    
	private Point position;
    
	private String parent;
	
}
