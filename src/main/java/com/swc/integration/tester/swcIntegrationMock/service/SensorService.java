package com.swc.integration.tester.swcIntegrationMock.service;

import java.util.List;

import com.swc.integration.tester.swcIntegrationMock.model.Sensor;
import com.swc.integration.tester.swcIntegrationMock.model.web.SensorDto;

public interface SensorService {

	public Sensor saveSensor(List<SensorDto> sensorkDto);
}
