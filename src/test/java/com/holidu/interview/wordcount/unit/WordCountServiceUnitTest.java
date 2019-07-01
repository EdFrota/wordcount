package com.holidu.interview.wordcount.unit;

import java.util.LinkedHashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.holidu.interview.wordcount.model.WordFrequencyDTO;
import com.holidu.interview.wordcount.service.WordCountService;
import com.holidu.interview.wordcount.service.WordCountServiceImpl;

@RunWith(SpringRunner.class)
public class WordCountServiceUnitTest {

	@TestConfiguration
	static class JobApplicationServiceImplTestContextConfig {
		@Bean
		public WordCountService wordCountService() {
			return new WordCountServiceImpl();
		}
	}

	@Autowired
	private WordCountService service;

	@Test
	public void givenTextContent_whenCheckingWordFrequency_thenNotNullResult() {
		// given
		String textContent = "a asd sdf dfg asd a asd b c b";
		
		// when
		WordFrequencyDTO result = service.countWordFrequencies("random-url", textContent);

		// then
		Assertions.assertThat(result).isNotNull();
	}
	
	@Test
	public void givenTextContent_whenCheckingWordFrequency_thenSortedWordFrequency() {
		// given
		String textContent = "a asd sdf dfg asd a asd b c b";
		
		// when
		WordFrequencyDTO result = service.countWordFrequencies("random-url", textContent);

		// then
		Map<String, Integer> expected = new LinkedHashMap<>();
		expected.put("asd", 3);
		expected.put("b", 2);
		expected.put("a", 2);
		expected.put("sdf", 1);
		expected.put("dfg", 1);
		expected.put("c", 1);
		
		Assertions.assertThat(expected.toString()).isEqualTo(result.getFrequencies().toString());
	}
}
