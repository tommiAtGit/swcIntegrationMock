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
public class Valve extends Link {

	// private Link link;

	private String station;

	private double diameter;

	private ValveTypeEnum valve_type;

	private double minor_loss;

	private double pressure;

	private String head_loss_curve;

	private double loss;

}
