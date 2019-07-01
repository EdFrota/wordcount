package com.holidu.interview.wordcount.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.holidu.interview.wordcount.controller.WordCountController;
import com.holidu.interview.wordcount.model.WordFrequencyDTO;
import com.holidu.interview.wordcount.utils.SortedKeyValue;

@SuppressWarnings("serial")
@Service
public class WordCountServiceImpl implements WordCountService {

	private static final Log LOG = LogFactory.getLog(WordCountController.class);
	private static final String REGEX_SPECIAL_CHARS = "[^\\p{javaSpaceChar}0-9a-zA-Z]+";
	
	@Override
	public WordFrequencyDTO countWordFrequencies(String url, String content) {
		LOG.info("Couting the word frequencies.");

		LOG.info("Filtering out special characters.");
		String noSpecialChars = content.toLowerCase().replaceAll(REGEX_SPECIAL_CHARS, StringUtils.EMPTY);

		LOG.info("Spliting the content by space.");
		String[] words = StringUtils.split(noSpecialChars, StringUtils.SPACE);

		LOG.info("Calculating word frequency.");
		Map<String, Integer> frequencies = calculateFrequency(words);

		LOG.info("Sorting word frequency.");
		Map<String, Integer> sortedFrequencies = sortFrequency(frequencies);

		return new WordFrequencyDTO(url, sortedFrequencies);
	}
	
	/**
	 * Calculate the word frequencies.
	 * @param words array of words
	 * @return Map of word frequencies.
	 */
	private Map<String, Integer> calculateFrequency(String[] words) {
		Map<String, Integer> wordMap = new LinkedHashMap<>();

		for (String word : words) {
			if (wordMap.containsKey(word)) {
				wordMap.put(word, wordMap.get(word) + 1);
			} else {
				wordMap.put(word, 1);
			}
		}
		return wordMap;
	}
	
	/**
	 * Sort the map of word frequency by value and key in reverse order.
	 * @param frequency map of word frequency.
	 * @return sorted word frequency.
	 */
	private Map<String, Integer> sortFrequency(Map<String, Integer> frequency) {
		SortedSet<SortedKeyValue> wordSet = new TreeSet<>();
		
		frequency.entrySet().forEach(entry -> {
			wordSet.add(new SortedKeyValue(entry.getKey(), entry.getValue()));
		});
		
		return wordSet.stream().collect(Collectors.toMap(
				SortedKeyValue::getKey, SortedKeyValue::getValue, (e1, e2) -> e2, LinkedHashMap::new));
	}

}
