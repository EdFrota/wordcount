package com.holidu.interview.wordcount.model;

import java.io.Serializable;

/**
 * DTO to deal with check word frequency request.
 * 
 * @author edmundofrota
 *
 */
@SuppressWarnings("serial")
public class URLDTO implements Serializable {

	private String url;

	public URLDTO() {
		super();
	}

	public URLDTO(String url) {
		this();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
