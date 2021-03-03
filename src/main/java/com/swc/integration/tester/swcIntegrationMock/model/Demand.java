package com.swc.integration.tester.swcIntegrationMock.model;

import java.util.List;

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
public class Demand {

	private String uuid;

	private String network;

	private String name;

	private String description;

	private double demand;

	private String demand_pattern;

	private String category;

	private String parent;

	private String address;

	private double lat; // --90, 90

	private double lon; // -180 , 180

	private double alt;

	private List<String> tags;

}
