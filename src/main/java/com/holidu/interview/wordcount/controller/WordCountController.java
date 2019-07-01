package com.holidu.interview.wordcount.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.holidu.interview.wordcount.model.URLDTO;
import com.holidu.interview.wordcount.model.WordFrequencyDTO;
import com.holidu.interview.wordcount.service.WordCountService;

@RestController
@RequestMapping("/api/words")
public class WordCountController {

	private static final Log LOG = LogFactory.getLog(WordCountController.class);
	private static final String HEADER_ACCEPT = "Accept=application/json";
	private static final String HEADER_CONTENT_TYPE = "Content-Type=application/json";
	private static final RestTemplate REST_TEMPLATE = new RestTemplate();
	private static final HttpHeaders HTTP_HEADERS = new HttpHeaders();
	private static final HttpEntity<String> HTTP_ENTITY_HEADERS = new HttpEntity<>(HTTP_HEADERS);
	
	static {
		HTTP_HEADERS.add("Content-Type", "text/plain");
	}

	@Autowired
	private WordCountService wordCountService;

	@PostMapping(headers = { HEADER_ACCEPT, HEADER_CONTENT_TYPE })
	public @ResponseBody ResponseEntity<WordFrequencyDTO> checkWordFrequency(@RequestBody URLDTO url) {
		LOG.info("Checking word frequency.");

		ResponseEntity<String> response;
		try {
			response = retrieveContent(url.getUrl());
		} catch (Exception e) {
			LOG.error("Error to request URL " + url.getUrl(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		try {
			WordFrequencyDTO wordFrequency = wordCountService
					.countWordFrequencies(url.getUrl(), response.getBody());

			return new ResponseEntity<>(wordFrequency, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Error to process the content of URL " + url.getUrl(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	private ResponseEntity<String> retrieveContent(String url) throws Exception {
		LOG.info("Request to " + url);
		return REST_TEMPLATE.exchange(url, HttpMethod.GET, HTTP_ENTITY_HEADERS, String.class);
	}

}
