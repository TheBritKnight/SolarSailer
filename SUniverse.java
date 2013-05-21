import java.util.ArrayList;

import acm.program.GraphicsProgram;

@SuppressWarnings("serial")
public class SUniverse extends GraphicsProgram{
	
	//Computer's constants
	public static final int APPLICATION_WIDTH = 700;
	public static final int APPLICATION_HEIGHT = 250;
	
	//Physic's Constants
	public static final double G = 6.67*Math.pow(10, -11);
	
	ArrayList<SObject> objs = new ArrayList<SObject>();
	
	public void init(){
		SRock rock = new SRock(400, 400, 25, 100);
		objs.add(rock);
		
		for(SObject thing : objs){
			add(thing);
		}//End for
		pause(1000);
	}
	
	public void run(){
		while(true){
			calcAndAddForces();
			
			//Have all of the objects act and then tell them to move
			for(SObject thing : objs){
				thing.act();
				thing.move(thing.getVel()[0], thing.getVel()[1]);
			}
			pause(10);
		}
	}
	
	private void calcAndAddForces(){
		//Cycle through all the objects, and account for the force of gravity due to each one
		for(SObject forcer : objs){
			for(SObject forcee : objs){
				if(forcee != forcer){
					double[] force = getGravForce(forcer, forcee);
				}//End if
			}//End for
		}//End for
	}//End calcAndAddForces
	
	//Calculates the force due to gravity of obj1 acting on obj2
	private double[] getGravForce(SObject obj1, SObject obj2){
		double mag = G*(obj1.getMass()*obj2.getMass())/Math.pow(getDistanceBetween(obj1, obj2), 2);
		
		//Find unit vector from obj1 to obj2
		double[] unitV = new double[]{obj2.getX()-obj1.getX(), obj2.getY() - obj1.getY()};
		double distance = getDistanceBetween(obj1, obj2);
		for(int i = 0; i < unitV.length; i++){ unitV[i] = unitV[i]/distance;}
		
		//Multiply the unit vector by the magnitude of the force to find the x and y components of the force
		double force[] = new double[unitV.length];
		for(int i = 0; i < unitV.length; i++){ force[i] = unitV[i]*mag; }
		
		return force;
	}//End method
	
	private double getDistanceBetween(SObject obj1, SObject obj2){
		return Math.hypot(Math.abs(obj1.getX()-obj2.getX()), Math.abs(obj1.getY() - obj2.getY()));
	}
	
}