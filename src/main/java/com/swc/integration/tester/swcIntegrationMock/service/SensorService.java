package com.swc.integration.tester.swcIntegrationMock.service;

import com.swc.integration.tester.swcIntegrationMock.model.Sensor;
import com.swc.integration.tester.swcIntegrationMock.model.web.SensorDto;

public interface SensorService {

	public Sensor saveSensor(SensorDto sensorkDto);
}