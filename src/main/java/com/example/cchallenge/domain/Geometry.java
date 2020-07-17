package com.example.cchallenge.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {
    private String type;
    private BigDecimal[] coordinates;
    
    public Geometry() {}
     
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinate(BigDecimal[] coordinates) {
		this.coordinates = coordinates;
	}

	public String toString() {
    	return String.format(" {type(%s) 0: %s 1: %s 2: %s} ", type, coordinates[0], coordinates[1], coordinates[2]);
    }
}
