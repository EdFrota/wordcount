package com.holidu.interview.wordcount.model;

import java.io.Serializable;
import java.util.Map;

/**
 * DTO to deal with check word frequency response.
 * 
 * @author edmundofrota
 *
 */
@SuppressWarnings("serial")
public class WordFrequencyDTO implements Serializable {

	private String url;
	private Map<String, Integer> frequencies;

	public WordFrequencyDTO() {
		super();
	}

	public WordFrequencyDTO(String url, Map<String, Integer> frequencies) {
		this();
		this.url = url;
		this.frequencies = frequencies;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, Integer> getFrequencies() {
		return frequencies;
	}

	public void setFrequencies(Map<String, Integer> frequencies) {
		this.frequencies = frequencies;
	}

}
