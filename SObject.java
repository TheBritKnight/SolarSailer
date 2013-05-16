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
	public SObject(double[] pos, double radius, double massNew) {
		super((radius * 2), (radius * 2), pos[0], pos[1]);
		position = pos;
		velocity = new double[] {0, 0};
		mass = massNew;
	}

	//Getters and Setters	
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

	public void setVel(double x, double y) {
		velocity[0] = x;
		velocity[1] = y;
	}
	public void setPosition(double x, double y) {
		position[0] = x;
		position[1] = y;
	}
	public void setMass(double m){
		if(m != 0){mass = m;}
	}
	public void setRadius(double r){
		if(r != 0){radius = r;}
	}
	
	//Methods: act, etc.
	
	public void addForce(double x, double y){
		double[] newForce = new double[]{x, y};
		forces.add(newForce);
	}
	
	public void act() {
		actForces();
		updateLocation();
	}
	
	private void actForces(){
		for(double[] force : forces){
			for(int i = 0; i < force.length; i++){
				velocity[i] = force[i]/mass;
			}//End inner for
		}//End for
	}
	
	private void updateLocation(){
		for(double v : velocity){
			setLocation(getPosition()[0]+velocity[0], getPosition()[1] + velocity[1]);
		}//End for
	}
	
	public void bounceX(){
		double[] vels = getVel();
		setVel(-vels[0], vels[1]);
	}
	
	public void bounceY(){
		double[] vels = getVel();
		setVel(vels[0], -vels[1]);
	}
	
}