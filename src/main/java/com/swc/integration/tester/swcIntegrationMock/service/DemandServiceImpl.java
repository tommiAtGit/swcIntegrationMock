package com.swc.integration.tester.swcIntegrationMock.service;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swc.integration.tester.swcIntegrationMock.model.Demand;
import com.swc.integration.tester.swcIntegrationMock.model.GateValve;
import com.swc.integration.tester.swcIntegrationMock.model.web.DemandDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DemandServiceImpl implements DemandService {

	private ObjectMapper mapper = new ObjectMapper();
	private static int SAMPLE_SIZE = 3;

	private static RestTemplate restTemplate;

	@Value("${swc.network.url}")
	private String networUrl;

	@Value("${swc.network.token}")
	private String networkApiToken;

	@Value("${swc.network.sendflag}")
	private String sendFlag;

	@Override
	public Demand saveDemand(String networkId, List<DemandDto> demandDtos) {

		Demand demand = null;
		List<Demand> sampleDemands = new ArrayList<Demand>();
		List<Demand> demands = new ArrayList<Demand>();

		int index = 0;

		for (DemandDto demandDto : demandDtos) {
			demand = Demand.builder().uuid(demandDto.getUuid()).network(demandDto.getNetwork())
					.name(demandDto.getName()).description(demandDto.getDescription()).demand(demandDto.getDemand())
					.demand_pattern(demandDto.getDemand_pattern()).category(demandDto.getCategory())
					.parent(demandDto.getParent()).address(demandDto.getAddress()).lat(demandDto.getLat())
					.lon(demandDto.getLon()).alt(demandDto.getAlt()).tags(demandDto.getTags()).build();

			if (index < SAMPLE_SIZE) {
				sampleDemands.add(demand);
				index++;
			}
			demands.add(demand);
		}

		// Print out sample of demands as json
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(sampleDemands);
			log.info("..at saveDemands, object as Json:  " + objectAsJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}
		if (sendFlag.equals("TRUE")) {
			log.info(" ");
			log.info("+ Send GateValves + ");
			createDemand(networkId, demands);
			log.info("End of GateValve send ");
		}

		return demand;
	}

	@Override
	public Demand updateDemand(String network, String demandId, DemandDto demandDto) {

		/// networks/{network}/demands/{demand}

		return null;
	}

	private ResponseEntity<String> createDemand(String network, List<Demand> demands) {
		final String serviceUrl = "/networks/" + network + "/demands";
		final String baseUrl = networUrl + serviceUrl;

		int postIndex = 0;
		int stepSize = 2;

		log.info("++ Start of Demand post: " + LocalDateTime.now() + "++");
		if ((demands == null) || (demands.size() < 1)) {
			log.error("..at CreateDemand, no gatevalves aviable:  ");
			return null;
		}
		URI uri = null;

		ResponseEntity<String> result = null;

		try {
			log.info(".. At CreateDemand, baseurl:  " + baseUrl);

			uri = new URI(baseUrl);

			restTemplate = new RestTemplate();
			for (Demand demand : demands) {
				postIndex++;
				HttpEntity<Demand> request = new HttpEntity<>(demand, defineHeaders());
				result = restTemplate.postForEntity(uri, request, String.class);
				if (postIndex % stepSize == 0) {
					log.info("Demand: " + postIndex + " send with result: " + result.getStatusCode());
				}

			}

		} catch (Exception e) {
			log.error("..at createDemand, Error occured:  ");
			e.printStackTrace();
			return null;
		}

		log.info("End of Demand post: " + LocalDateTime.now());

		return result;
	}

	private HttpHeaders defineHeaders() {

		String token = networkApiToken;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(token);
		headers.set("Accept", "application/vnd.alva.swc.network+json;v=1");
		return headers;

	}

}
