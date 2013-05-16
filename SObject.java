package universe;

import java.util.ArrayList;

import acm.graphics.GOval;

public abstract class SObject extends GOval{

	/**
	*Abstract superclass for celestial bodies
	*/

	//Instance Variables
	
	private double mass;
	private double radius;

	
	private double[] velocity;

	private ArrayList<double[]> forces;

	//Constructor
	
	public SObject(double[] pos, double radius, double mass){
	super(radius*2, radius*2);
	setPosition(pos[0], pos[1]);
	velocity = new double[] {0, 0};
	mass = mass;
	}
	
	
	//Methods get
	
	public double[] getVel() {
		return velocity;
	}
	
	public double[] getPos() {
		return position;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getMass() {
		return mass;
	}

	public ArrayList<double[]> getForces(){
		return forces;
	}
	
	
	//Methods Set
	
	public void setVel(double[] vel) {
		velocity = vel;
	}
	
	public void setPos(double[] newPos) {
		setPosition(pos[0], pos[1]);
	}
	
	public void setMass(double m){
		if(m != 0){mass = m;}
	}
	
	public void setRadius(double r){
		if(r != 0){radius = r;}
	}
	
}