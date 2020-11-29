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
public class MixingModel {

	private MixingModelEnum model;
	
	private double volume;
}
