package com.example.cchallenge.calculation;

import java.math.BigDecimal;

import com.example.cchallenge.domain.Point;

public class Algorithm {

	public static BigDecimal calculateDistance(Point a, Point b) {
		double earthRadius = 6371;
		BigDecimal latitudeA = new BigDecimal(Math.toRadians(a.getLatitude().doubleValue()));
		BigDecimal longitudeA = new BigDecimal(Math.toRadians(a.getLongitude().doubleValue()));
		BigDecimal latitudeB = new BigDecimal(Math.toRadians(b.getLatitude().doubleValue()));
		BigDecimal longitudeB = new BigDecimal(Math.toRadians(b.getLongitude().doubleValue()));

		BigDecimal latitudeDistance = latitudeB.subtract(latitudeA);
		BigDecimal longitudeDistance = longitudeB.subtract(longitudeA);

		//
		BigDecimal sinLatDist = new BigDecimal(Math.sin(latitudeDistance.doubleValue() / 2));
		BigDecimal cosLatA = new BigDecimal(Math.cos(latitudeA.doubleValue()));
		BigDecimal cosLatB = new BigDecimal(Math.cos(latitudeB.doubleValue()));
		BigDecimal sinLonDist = new BigDecimal(Math.sin(longitudeDistance.doubleValue() / 2));

		BigDecimal aux = cosLatA.multiply(cosLatB).multiply(new BigDecimal(Math.pow(sinLonDist.doubleValue(), 2)));
		BigDecimal arg = aux.add(new BigDecimal(Math.pow(sinLatDist.doubleValue(), 2)));

		BigDecimal argSqrt = new BigDecimal(Math.sqrt(arg.doubleValue()));
		BigDecimal result = new BigDecimal(Math.asin(argSqrt.doubleValue()) * 2);

		return new BigDecimal(earthRadius * result.doubleValue());
	}
}
