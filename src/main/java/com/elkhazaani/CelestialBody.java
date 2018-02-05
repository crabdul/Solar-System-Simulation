package com.elkhazaani;

import java.awt.Color;

/*
 * Class presents an object in the Solar System
 */
public abstract class CelestialBody {
	protected String name;
	protected Position position; // x,y coordinates of object on animation panel
	protected Position orbitCentre; // x,y coordinates of orbit centre on animation panel
	protected double orbitPeriod; // orbit period of object
	protected Color colour; // colour of object on animation panel
	protected int size; // size of object on animation panel
	
	protected int size(){return this.size;}; 
	protected Color colour(){return this.colour;}; 
	/* Methods to implement in subclasses */
	abstract String name(); // name of object
	abstract Position getPosition(); // position of object
}
