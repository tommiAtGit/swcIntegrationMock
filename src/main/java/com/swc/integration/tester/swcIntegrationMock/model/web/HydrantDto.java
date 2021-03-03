package com.swc.integration.tester.swcIntegrationMock.model.web;

import com.swc.integration.tester.swcIntegrationMock.model.Node;

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

public class HydrantDto extends Node {

	private double open_time;

	private double close_time;

	private double max_flow;

	private double min_pressure;

	private double diameter;

}