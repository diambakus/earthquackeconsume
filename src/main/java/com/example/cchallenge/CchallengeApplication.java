package com.example.cchallenge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.cchallenge.domain.EarthQuakes;
import com.example.cchallenge.domain.Feature;
import com.example.cchallenge.domain.Point;

@SpringBootApplication
public class CchallengeApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CchallengeApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Point givenPoint = new Point();
			givenPoint.setLatitude(new BigDecimal(args[0]));
			givenPoint.setLongitude(new BigDecimal(args[1]));
			
			EarthQuakes earthQuakes = restTemplate.getForObject(
					"https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson",
					EarthQuakes.class);
			Set<Point> points = new TreeSet<>(Comparator.comparing(Point::getDistance));
            Point point;
            for (Feature feature: earthQuakes.getFeatures()) {
            	point = new Point();
            	point.setTitle(feature.getProperties().getTitle());
            	BigDecimal[] coordinate = feature.getGeometry().getCoordinates();
            	point.setLongitude(coordinate[0]);
            	point.setLatitude(coordinate[1]);
            	point.setDistance(givenPoint);
            	points.add(point);
            }
            int earthQuackeCounter = 0; 
            for (Point xpoint: points) {
            	System.out.println(xpoint.getTitle() + " || "+xpoint.getDistance().setScale(0, RoundingMode.HALF_UP));
            	earthQuackeCounter++;
            	if(earthQuackeCounter == 10) break;
            }
		};
	}

	@Bean
	public RestTemplate getrestTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}
}
