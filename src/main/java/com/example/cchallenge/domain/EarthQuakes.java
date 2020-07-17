package com.example.cchallenge.domain;

public class EarthQuakes {

	private String type;
	private Feature[] features;

	public EarthQuakes() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Feature[] getFeatures() {
		return features;
	}

	public void setFeatures(Feature[] features) {
		this.features = features;
	}

	public String toString() {
		for (Feature feature : features) {
			Geometry geometry = feature.getGeometry();
			System.out.println(geometry.toString());
		}
		return String.format("{ type(%s) }", type);
	}
}
