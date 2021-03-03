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
public class FlowSensor extends Sensor {

	private boolean reverse;

	@Builder
	public FlowSensor(String id, String ext_id, String sensor_id, SensorTypeEnum sensor_type, Point position,
			String parent, String reverse) {
		super(id, ext_id, sensor_id, sensor_type, position, parent);
		this.reverse = Boolean.parseBoolean(reverse);
	}
}