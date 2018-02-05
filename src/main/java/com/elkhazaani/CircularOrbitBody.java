package com.elkhazaani;

/*
 * Class represents a celestial body with near circular orbit 
 * i.e. planets, asteroids
 */
public abstract class CircularOrbitBody extends CelestialBody {	
	protected int orbitRadius; // orbit radius of object
	protected double angularSpeed; // angular speed of object
	protected double orbitAngle = 0; // starting orbit angle
	protected double delta; // angle increments
	protected double delay = 50; // Delay in ms between steps
	
}
