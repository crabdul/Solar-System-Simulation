package com.elkhazaani;

import java.awt.Color;

/*
 * Class represents a planet
 */
public class Planet extends CircularOrbitBody {

	private int numOrbits = 0;

	/*
	 * Construct a planet
	 * 
	 * @param planetName    name of planet
	 * @param orbitCentre   centre of orbit
	 * @param orbitRadius   radius of orbit
	 * @param orbitTime     orbit period
	 * @param colour        colour of object in animation
	 * @param size          size of object in animation
	 */
	Planet(String planetName, Position orbitCentre, int orbitRadius, double orbitTime, Color colour, int size) {
		super();
		this.name = planetName;
		this.colour = colour;
		this.size = size;
		this.orbitCentre = orbitCentre;
		this.orbitRadius = orbitRadius;
		this.orbitPeriod = orbitTime;
		this.position = new Position(orbitCentre.x(),orbitCentre.y()+this.orbitRadius);
		this.angularSpeed = 2*Math.PI/this.orbitPeriod; 
		this.delta = 2*Math.PI*this.delay/(this.orbitPeriod*1000);
	}
	
	@Override
	public String name() {
		return this.name;
	}
	@Override
	public Position getPosition() {
		updatePosition();
		return this.position;
	}
    /* Calculate new position */
	private void updatePosition() {

		this.orbitAngle += delta;
		// Check if lap completed 
		if(this.orbitAngle > Math.PI * 2) {
			this.orbitAngle %= Math.PI * 2;
			/* Increment orbit every lap */
			updateOrbits();
		}
		/* Set new x,y coordinates */
		this.position.setX((int)((Math.cos(this.orbitAngle) * this.orbitRadius) + this.orbitCentre.x()));
		this.position.setY((int)((Math.sin(this.orbitAngle) * this.orbitRadius) + this.orbitCentre.y()));
	}
	
	public int getOrbitRadius(){
		return this.orbitRadius;
	}
	
	public int getOrbits() {
		return this.numOrbits;
	}
	private void updateOrbits() {
		numOrbits++;
	}

}
