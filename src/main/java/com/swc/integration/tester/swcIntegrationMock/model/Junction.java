package com.swc.integration.tester.swcIntegrationMock.model;

import java.util.List;

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
public class Junction extends Node {

	private double elevation;

	private double demand;

	// private String demand_pattern;

	// private List<Demand>demands;

	private double emitter_coeff;

	private boolean ignore_for_geocoded;

	private double required_head;

	private String symbol;

	private List<String> zone;

	private List<String> tags;

}
