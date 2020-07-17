package com.example.cchallenge.domain;

import java.math.BigDecimal;

import com.example.cchallenge.calculation.Algorithm;

public class Point {

	BigDecimal latitude;
	BigDecimal longitude;
	BigDecimal distance; // Distance from given point
	String title;
	
	public Point() {
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Point))
			return false;
		Point other = (Point) o;
		return (this.latitude == other.latitude) && (this.longitude == other.longitude);
	}
	
	@Override
	public final int hashCode() {
		int result = 13;
		if (title != null)
			result = 31 * result + title.hashCode();
		return result;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getDistance() {
		return distance;
	}

	public void setDistance(Point givenPoint) {
		this.distance = Algorithm.calculateDistance(givenPoint, this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toString() {
		return String.format("title=(%s) lat(%s) lon(%s) distance(%s)", title, latitude, longitude, distance);
	}
}
