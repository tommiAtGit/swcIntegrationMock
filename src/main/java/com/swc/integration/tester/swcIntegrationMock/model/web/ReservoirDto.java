package com.swc.integration.tester.swcIntegrationMock.model.web;

import java.util.List;

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
public class ReservoirDto extends Node {

	private String station;

	private double head;

	private String head_pattern;

	private String symbol;

	private List<String> tags;
}
