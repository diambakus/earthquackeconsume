package com.example.cchallenge.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {

	private String id;
	private Properties properties;
	private Geometry geometry;

	public Feature() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperty(Properties properties) {
		this.properties = properties;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String toString() {
		return String.format("{ id=%s }", this.id);
	}
}
