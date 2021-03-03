package com.swc.integration.tester.swcIntegrationMock.service;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swc.integration.tester.swcIntegrationMock.model.GateValve;
import com.swc.integration.tester.swcIntegrationMock.model.web.GateValveDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GatevalveServiceImpl implements GatevalveService {

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
	public GateValve saveGateValve(String networkId, List<GateValveDto> gatevalveDtos) {

		GateValve gateValve = null;
		List<GateValve> gateValves = new ArrayList<GateValve>();
		List<GateValve> allGateValves = new ArrayList<GateValve>();
		int index = 0;

		for (GateValveDto gatevalveDto : gatevalveDtos) {

			gateValve = GateValve.builder().uuid(gatevalveDto.getUuid()).network(gatevalveDto.getNetwork())
					.name(gatevalveDto.getName()).change_time(gatevalveDto.getChange_time())
					.change_back_time(gatevalveDto.getChange_back_time()).closed(gatevalveDto.getClosed())
					.lat(gatevalveDto.getLat()).lon(gatevalveDto.getLon()).alt(gatevalveDto.getAlt())
					.ext_ids(gatevalveDto.getExt_ids()).tags(gatevalveDto.getTags()).zones(gatevalveDto.getZones())
					.build();

			if (index < SAMPLE_SIZE) {
				gateValves.add(gateValve);
				index++;
			}
			allGateValves.add(gateValve);
		}
		// Print out sample of pipes as json
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(gateValves);
			log.info("..at saveGateValve , object as Json:  " + objectAsJson);
			if (sendFlag.equals("TRUE")) {
				log.info(" ");
				log.info("+ Send GateValves + ");
				createGateValves(networkId, allGateValves);
				log.info("End of GateValve send ");
			}

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}

		return gateValve;

	}

	@Override
	public GateValve updateGateValve(String networkId, String gateValveId, GateValveDto gatevalveDto) {

		ObjectMapper objectMapper = new ObjectMapper();
		GateValve gateValve = null;
		final String serviceUrl = "/networks/" + networkId + "/gatevalves/" + gateValveId;

		final String baseUrl = networUrl + serviceUrl;

		URI uri = null;

		// ResponseEntity<String> result = null;

		try {

			log.info("..at updateGateValve, baseurl: " + baseUrl);

			String entityJson = objectMapper.writeValueAsString(gatevalveDto);
			log.info("..at updateGateValve , object as Json:  " + entityJson);

			if (sendFlag.equals("TRUE")) {
				uri = new URI(baseUrl);

				restTemplate = new RestTemplate();

				HttpEntity<String> request = new HttpEntity<>(entityJson, defineHeaders());

				restTemplate.put(uri, request);

				gateValve = objectMapper.readValue(entityJson, GateValve.class);
			}

		} catch (Exception e) {
			log.error("Error occured while updateing entity: ");
			e.printStackTrace();
			return null;
		}

		log.info("Entity uptaded " + HttpStatus.OK);

		return gateValve;

	}

//Send test gateValves
	private ResponseEntity<String> createGateValves(String network, List<GateValve> gateValves) {
		final String serviceUrl = "/networks/" + network + "/gatevalves";
		final String baseUrl = networUrl + serviceUrl;

		int postIndex = 0;
		int stepSize = 2;

		log.info("++ Start of GateValve post: " + LocalDateTime.now() + "++");
		if ((gateValves == null) || (gateValves.size() < 1)) {
			log.error("..at createGateValves, no gatevalves aviable:  ");
			return null;
		}
		URI uri = null;

		ResponseEntity<String> result = null;

		try {
			log.info(".. At createGateValves, baseurl:  " + baseUrl);

			uri = new URI(baseUrl);

			restTemplate = new RestTemplate();
			for (GateValve gateValve : gateValves) {
				postIndex++;
				HttpEntity<GateValve> request = new HttpEntity<>(gateValve, defineHeaders());
				result = restTemplate.postForEntity(uri, request, String.class);
				if (postIndex % stepSize == 0) {
					log.info("GateValve: " + postIndex + " send with result: " + result.getStatusCode());
				}

			}

		} catch (Exception e) {
			log.error("..at createGateValves, Error occured:  ");
			e.printStackTrace();
			return null;
		}

		log.info("End of GateValve post: " + LocalDateTime.now());

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
