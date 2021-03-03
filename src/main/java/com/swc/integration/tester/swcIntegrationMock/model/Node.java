package com.swc.integration.tester.swcIntegrationMock.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Node {

	private String uuid;

	private String name;

	private String description;

	private double quality;

	// private NodeSource source;

	private Point coordinates;

}
