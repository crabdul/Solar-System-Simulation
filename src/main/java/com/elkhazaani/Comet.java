package com.elkhazaani;

import java.awt.Color;

/*
 * Class represents a comet
 */
public class Comet extends CelestialBody {
	
	private final static double TWO_PI = Math.PI * 2; // 2*pi
	
	private double majorAxis;
	private double e; 
	private double orbitPeriod; 
	private double time = 0; // set initial time
	private static final int iterations = 4; // number of iterations in Newton-Raphson method
	
	/*
	 * Construct a comet
	 * 
	 * @param name          name of comet
	 * @param orbitCentre   centre of orbit
	 * @param majorAxis     major axis of comet orbit
	 * @param e             eccentricity of orbit
	 * @param orbitPeriod   orbit period
	 * @param colour        colour of object in animation
	 * @param size          size of object in animation
	 */
	public Comet(String name,Position orbitCentre, int majorAxis, double e, double orbitPeriod, Color colour, int size) {
		this.name = name;
		this.orbitCentre = orbitCentre;
		this.majorAxis = majorAxis;
		this.e = e;
		this.orbitPeriod= orbitPeriod;
		this.colour = colour;
		this.size = size;	
	}
	
    /* Calculate new position for given increment of time */
	public Position getPosition() {
		/* Calculate mean anomaly of orbit at specified time */
		double meanAnomaly = TWO_PI / this.orbitPeriod * time;
		/* Iteratively calculate eccentric anomaly of orbit */
		double eccentricAnomaly = getEccentricAnomaly(e, meanAnomaly, iterations);
		/* Calculate true anomaly */
		double trueAnomaly = 2 * Math.atan(Math.sqrt((1 + e) / (1 - e))
				* Math.tan(eccentricAnomaly / 2));
		/* Calculate length of radius */
		double nominator = majorAxis * (1 - Math.pow(e, 2));
		double denominator = 1 + e * Math.cos(trueAnomaly);
		double r = nominator / denominator;
		time += 0.01;
		return new Position(orbitCentre.x() + (int) (r* Math.cos(trueAnomaly)), 
				orbitCentre.y() + (int)(r*Math.sin(trueAnomaly)));
	}

	/**
	 * Iteratively process to estimate the eccentric anomaly of an orbit for a given
	 * mean anomaly and eccentricity
	 */
	private static double getEccentricAnomaly(double eccentricity, double meanAnomaly, int iterations){
		double tempResult = meanAnomaly;
		double numerator;

		for (int i = 0; i < iterations; i++) {
			numerator = meanAnomaly + eccentricity * Math.sin(tempResult)
					- eccentricity * tempResult * Math.cos(tempResult);
			tempResult = numerator / (1 - eccentricity * Math.cos(tempResult));
		}
		return tempResult;
	}

	@Override
	public String name() {
		return this.name;
	}
}

