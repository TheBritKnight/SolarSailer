import java.util.*;

import acm.program.GraphicsProgram;

@SuppressWarnings("serial")
public class SUniverse extends GraphicsProgram{
	
	//Instance Variables
	private static int HEIGHT;
	private static int WIDTH;
	
	//Physic's Constants
	//NOTE: Units of mass are in 10^14 kg
	public static final double G = 6.67*Math.pow(10, 3);
	
	ArrayList<SObject> objs = new ArrayList<SObject>();
	
	public void init(){
		SRock rock = new SRock(400, 400, 25, 10);
		SRock neutrino = new SRock(100, 100, 15, 5);
		objs.add(rock);
		objs.add(neutrino);
		
		for(SObject thing : objs){
			add(thing);
		}//End for
		pause(1000);
	}
	
	public void run(){
		while(true){
			//Update Width and Height
			HEIGHT = this.getHeight();
			WIDTH = this.getWidth();
			
			calcAndAddForces();
			
			//Have all of the objects act and then tell them to move
			for(SObject thing : objs){
				thing.act();
				thing.move(thing.getVel()[0], thing.getVel()[1]);
				
				/*//Check for walls
				if(thing.getX() > WIDTH){
					thing.setLocation(0, thing.getY());
				} else if(thing.getX() < 0){
					thing.setLocation(WIDTH, thing.getY());
				}
				if(thing.getY() < 0){
					thing.setLocation(thing.getX(), HEIGHT);
				} else if(thing.getY() > HEIGHT){
					thing.setLocation(thing.getX(), 0);
				}*/
				
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
					forcee.addForce(force[0], force[1]);
				}//End if
			}//End for
		}//End for
	}//End calcAndAddForces
	
	//Calculates the force due to gravity of obj1 acting on obj2
	private double[] getGravForce(SObject obj1, SObject obj2){
		double mag = G*(obj1.getMass()*obj2.getMass())/Math.pow(getDistanceBetween(obj1, obj2), 2);
		System.out.println("Magntiude: " + mag);
		
		//Find unit vector from obj1 to obj2
		double[] unitV = new double[]{obj2.getX()-obj1.getX(), obj2.getY() - obj1.getY()};
		System.out.println("Vector: " + Arrays.toString(unitV));
		double distance = getDistanceBetween(obj1, obj2);
		for(int i = 0; i < unitV.length; i++){ unitV[i] = unitV[i]/distance;}
		System.out.println("Unit Vector: " + Arrays.toString(unitV));
		
		//Multiply the unit vector by the magnitude of the force to find the x and y components of the force
		double force[] = new double[unitV.length];
		for(int i = 0; i < unitV.length; i++){ force[i] = unitV[i]*mag; }
		System.out.println("Force Vector: " + Arrays.toString(force));
		
		return force;
	}//End method
	
	private double getDistanceBetween(SObject obj1, SObject obj2){
		return Math.hypot(Math.abs(obj1.getX()-obj2.getX()), Math.abs(obj1.getY() - obj2.getY()));
	}
	
}