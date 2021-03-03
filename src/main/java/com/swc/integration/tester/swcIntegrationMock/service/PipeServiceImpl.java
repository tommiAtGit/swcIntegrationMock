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
import com.swc.integration.tester.swcIntegrationMock.model.Pipe;
import com.swc.integration.tester.swcIntegrationMock.model.web.PipeDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PipeServiceImpl implements PipeService {

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
	public Pipe savePipe(String networkId, List<PipeDto> pipeDtos) {

		Pipe pipe = null;
		List<Pipe> pipes = new ArrayList<Pipe>();
		List<Pipe> allPipes = new ArrayList<Pipe>();

		int index = 0;

		for (PipeDto pipeDto : pipeDtos) {
			pipe = Pipe.builder().uuid(pipeDto.getUuid()).name(pipeDto.getName()).start(pipeDto.getStart())
					.end(pipeDto.getEnd()).vertices(pipeDto.getVertices()).leakage_coeff1(pipeDto.getLeakage_coeff1())
					.leakage_coeff2(pipeDto.getLeakage_coeff2()).status(pipeDto.getStatus())
					.extra_fields(pipeDto.getExtra_fields()).custom_length(pipeDto.getCustom_length())
					.diameter(pipeDto.getDiameter()).length(pipeDto.getLength()).material(pipeDto.getMaterial())
					.year(pipeDto.getYear()).zones(pipeDto.getZones()).tags(pipeDto.getTags())
					.ext_ids(pipeDto.getExt_ids()).build();
			if (index < SAMPLE_SIZE) {
				pipes.add(pipe);
				index++;
			}
			allPipes.add(pipe);
		}
		// Print out sample of pipes as json
		String objectAsJson;
		try {
			objectAsJson = mapper.writeValueAsString(pipes);
			log.info("..at savePipes, object as Json:  " + objectAsJson);
		} catch (JsonProcessingException e) {
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}

		String objectJson;
		try {
			if (pipes.size() > 0) {
				objectJson = mapper.writeValueAsString(pipes);
				log.info("..at savePipes, pipe snapshot:  " + objectJson);
				if (sendFlag.equals("TRUE")) {
					log.info(" ");
					log.info("+ Send Pipes + ");
					createTestPipes(networkId, allPipes);
					log.info("End of pipes with sensors ");
				}
			}

		} catch (JsonProcessingException e) {
			log.error("Error occured while parsing json: ");
			e.printStackTrace();
		}

		return pipe;
	}

	// Send test pipes
	private ResponseEntity<String> createTestPipes(String network, List<Pipe> pipes) {

		final String serviceUrl = "/networks/" + network + "/pipes";
		final String baseUrl = networUrl + serviceUrl;
		int index = 0;
		int stepSize = 100;

		log.info("++ Start of Pipe post: ++ " + LocalDateTime.now());
		if ((pipes == null) || (pipes.size() < 1)) {
			log.error("..at createTestPipes, no pipes aviable:  ");
			return null;
		}
		URI uri = null;

		ResponseEntity<String> result = null;

		try {
			log.info(".. At createTestPipes, baseurl:  " + baseUrl);

			uri = new URI(baseUrl);

			restTemplate = new RestTemplate();
			for (Pipe pipe : pipes) {
				index++;
				HttpEntity<Pipe> request = new HttpEntity<>(pipe, defineHeaders());

				result = restTemplate.postForEntity(uri, request, String.class);
				if (index % stepSize == 0) {
					log.info("Pipe: " + index + " send with result: " + result.getStatusCode());
				}

			}

		} catch (Exception e) {
			log.error("..at createTestPipes, Error occured:  ");
			e.printStackTrace();
			return null;
		}

		log.info("Junctions posted with response: " + result.getStatusCode());

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
