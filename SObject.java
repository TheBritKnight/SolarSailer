import java.util.ArrayList;
import acm.graphics.*;

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
	public SObject(int x, int y, double radius, double massNew) {
		super((radius * 2), (radius * 2), x-radius, y-radius);
		velocity = new double[] {0, 0};
		mass = massNew;
		setFilled(true);
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
	public void setLocation(int x, int y) {
		super.setLocation(x-radius, y-radius);
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
	
	protected void actForces(){
		for(double[] force : forces){
			for(int i = 0; i < force.length; i++){
				velocity[i] = force[i]/mass;
			}//End inner for
		}//End for
	}
	
	protected void updateLocation(){
		setLocation(getX()+velocity[0], getY() + velocity[1]);
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
	
	private void bounceX(){
		double[] vels = getVel();
		setVel(-vels[0], vels[1]);
	}
	
	private void bounceY(){
		double[] vels = getVel();
		setVel(vels[0], -vels[1]);
	}
	
}