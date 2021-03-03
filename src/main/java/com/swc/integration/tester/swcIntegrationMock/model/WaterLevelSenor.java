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
public class WaterLevelSenor extends Sensor {

	private double vertical_position;

	@Builder
	public WaterLevelSenor(String id, String ext_id, String sensor_id, SensorTypeEnum sensor_type, Point position,
			String parent, double vertical_position) {
		super(id, ext_id, sensor_id, sensor_type, position, parent);
		this.vertical_position = vertical_position;
	}
}
