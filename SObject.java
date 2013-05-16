package universe;

import java.util.ArrayList;
import acm.graphics.*;

@SuppressWarnings("serial")
public abstract class SObject extends GOval{
	
	/**
	*Abstract superclass for celestial bodies
	*/

	//Instance Variables
	private double mass;
	private double radius;
	private double[] velocity;
	private double[] position;
	private ArrayList<double[]> forces;

	//Constructor
	public SObject(double[] pos, double radius) {
		super(pos[0]*2,pos[1]*2);
		position = pos;
		velocity = new double[] {0, 0};
	}

	//Methods get
	
	public double[] getVel() {
		return velocity;
	}	
	public double[] getPosition() {
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
	public void setPosition(double[] newPosition) {
		position = newPosition;
	}
	public void setMass(double m){
		if(m != 0){mass = m;}
	}
	public void setRadius(double r){
		if(r != 0){radius = r;}
	}
	
	//Methods: act, etc.
	
	public void act() {
		//code to be added
	}
	
}