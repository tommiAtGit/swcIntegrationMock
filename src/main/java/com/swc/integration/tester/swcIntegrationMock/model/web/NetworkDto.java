package com.swc.integration.tester.swcIntegrationMock.model.web;

import com.swc.integration.tester.swcIntegrationMock.model.NetworkChildren;

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
public class NetworkDto {

	private String uuid;

    private String name;
    
    private String description;

    private  NetworkChildren children;

}