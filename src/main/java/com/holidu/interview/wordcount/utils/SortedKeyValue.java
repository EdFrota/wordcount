package com.holidu.interview.wordcount.utils;

/**
 * Utility class to sort words by frequency and itself.
 * 
 * Reverse order value and key.
 * 
 * @author edmundofrota
 *
 */
public class SortedKeyValue implements Comparable<SortedKeyValue> {
	private String key;
	private Integer value;
	
	public SortedKeyValue(String key, Integer value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(SortedKeyValue o) {
		return value.equals(o.value) ? o.key.compareTo(key) : o.value.compareTo(value);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
