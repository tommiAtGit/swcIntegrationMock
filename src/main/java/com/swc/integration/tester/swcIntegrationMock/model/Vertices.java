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
@Builder
public class Vertices {

	// VerticePoints items;
	private double lat; // minimum: -90.0, maximum: 90.0

	private double lon; // minimum: -180.0, maximum: 180.0

	private double alt;

	private String uuid;

	private String ext_id;

}
