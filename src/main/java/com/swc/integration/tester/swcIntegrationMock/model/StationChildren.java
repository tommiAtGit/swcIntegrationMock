package com.swc.integration.tester.swcIntegrationMock.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class StationChildren {

	private List<Valve> valves;

	private List<Reservoir> reservoirs;

	private List<Pump> pumps;

	private List<Tank> tanks;

	private List<Battery> batteries;
}
