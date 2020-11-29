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
public class NetworkChildren {


	private List<Station> station;
   
	private List<Pipe>  pipes;

	private List<GateValve>gatevalves;
	   
	private  List<Area> areas;

	private List <Junction> junctions;

	private List<Hydrant> hydrants;

	private List<Sensor>  sensors;
 
	private List<Demand>  demands;
 
}
