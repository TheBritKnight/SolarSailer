import java.util.ArrayList;
import acm.graphics.*;

public abstract class SObject extends GOval{
	
	/**
	*Abstract superclass for celestial bodies
	*/

	//Instance Variables
	private long mass;
	private double radius;
	private double[] velocity;
	private ArrayList<double[]> forces = new ArrayList<double[]>();

	//Constructor
	/**
	 * 
	 * @param x x position
	 * @param y y position
	 * @param radius The radius of the object
	 * @param massNew the mass of the object
	 */
	public SObject(int x, int y, double rad, long massNew, double xVel, double yVel) {
		super( x, y, (rad * 2), (rad * 2));
		radius = rad;
		velocity = new double[] {xVel, yVel};
		mass = massNew;
		setFilled(true);
		setVisible(true);
	}

	//Getters and Setters	
	public double[] getVel() {
		return velocity;
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
	//Sets Location at Center
	public void setLocation(double x, double y) {
		super.setLocation(x, y);
	}
	//Gets location of center
	public double getX(){
		return super.getX();
	}
	public double getY(){
		return super.getY();
	}
	public void setMass(long m){
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
	}
	
	protected void actForces(){
		for(double[] force : forces){
			for(int i = 0; i < force.length; i++){
				velocity[i] += force[i]/mass;
			}//End inner for
		}//End for
	}
	
	/**
	 * Called by runner class on collision with other object
	 * 
	 * @param onXSide if the impact occured on the left or right of the object
	 * @param onYSide if the impact in on the top or bottom of the object
	 * @return true if the other object is to be removed (i.e. if this is a SStar), false otherwise
	 */
	public boolean impact(boolean onXSide, boolean onYSide){
		if(onXSide){
			bounceX();
		}
		if(onYSide){
			bounceY();
		}
		
		return false;
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