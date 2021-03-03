package com.swc.integration.tester.swcIntegrationMock.model.web;

import java.util.List;

import com.swc.integration.tester.swcIntegrationMock.model.StationChildren;
import com.swc.integration.tester.swcIntegrationMock.model.StationSettings;

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
public class StationDto {
	private String uuid;

	private String network;

	private String name;

	private String description;

	private StationSettings settings;

	private String code;

	private List<String> tags;

	private StationChildren children;
}
