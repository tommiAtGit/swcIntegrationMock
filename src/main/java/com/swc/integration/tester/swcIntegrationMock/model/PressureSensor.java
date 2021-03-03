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

public class PressureSensor extends Sensor {
	private double offset_error;

	@Builder
	public PressureSensor(String id, String ext_id, String sensor_id, SensorTypeEnum sensor_type, Point position,
			String parent, double offset_error) {
		super(id, ext_id, sensor_id, sensor_type, position, parent);
		this.offset_error = offset_error;
	}

}