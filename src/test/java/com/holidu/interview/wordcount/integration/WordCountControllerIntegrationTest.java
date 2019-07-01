package com.holidu.interview.wordcount.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.holidu.interview.wordcount.model.URLDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WordCountControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper objectMapper;

	private static final String API_PATH = "/api/words";

	@Test
	public void givenValidUrl_whenCheckWordFrequency_thenStatusOk() throws Exception {
		// given
		final String url = "https://gist.githubusercontent.com/joschi/3a75e759327bb83ad35f89b4639d16a3/raw/efbc10e0b31f0b539b9ca25154a0ab87b438f00c/lorem_ipsum.txt";
		final String requestContent = objectMapper.writeValueAsString(new URLDTO(url));

		// when
		mvc.perform(MockMvcRequestBuilders.post(API_PATH)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestContent))
		// then
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void givenInvalidUrl_whenCheckWordFrequency_thenStatusBadRequest() throws Exception {
		// given
		final String url = "invalid-url";
		final String requestContent = objectMapper.writeValueAsString(new URLDTO(url));

		// when
		mvc.perform(MockMvcRequestBuilders.post(API_PATH)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestContent))
		// then
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
