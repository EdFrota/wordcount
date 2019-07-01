package com.holidu.interview.wordcount.service;

import java.io.Serializable;

import com.holidu.interview.wordcount.model.WordFrequencyDTO;

public interface WordCountService extends Serializable {

	/**
	 * Count the frequency of each word of <code>content</code>.
	 * @param url content source.
	 * @param content String containing the words to be counted.
	 * @return {@link WordFrequencyDTO} with the url and sorted word frequencies.
	 */
	WordFrequencyDTO countWordFrequencies(String url, String content);
}
