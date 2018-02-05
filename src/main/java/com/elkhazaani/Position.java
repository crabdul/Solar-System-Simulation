package com.elkhazaani;

/*
 * Class presents position of celestial object
 */
public class Position {
	/* x,y coordinates on panel */
	private int x;
	private int y;
	/* 
	 * Construct position of object
	 * @param x  x-coordinate
	 * @param y  y-coordinate
	 */
	Position(int x, int y){
		this.x=x;
		this.y=y;
	}
	/* Setter methods */
	void setX(int x){this.x = x;}
	void setY(int y){this.y = y;}
	/* Getter methods */
	int x(){return this.x;}
	int y(){return this.y;}
}
