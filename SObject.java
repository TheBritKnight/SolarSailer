package universe;

import java.util.ArrayList;

import acm.graphics.GOval;

public abstract class SObject extends GOval{

	/**
	 * Abstract superclass for celestial bodies
	 */
	
	//Instance Variables
	private double mass;
	private double radius;
	
	private double[] position;
	private double[] velocity;
	
	private ArrayList<double[]> forces;
	
	//Constructor
	//	Overload the shit out of it
	public SObject(double[] pos, double radius){
		super(radius*2, radius*2);
		
		position = pos;
		velocity = new double[] {0, 0};
		
		
	}
	
}
