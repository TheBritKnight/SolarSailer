package universe;

import java.util.Arraylist;

import acm.graphics/GOval;

public abstract class SStar extends SObject {

	/**
	*Class for Stars
	*/
	
	//Instance Variables
	private int consumed;
	private boolean nova = false;
	
	public SStar(int x, int y, double radius, double massNew){
		super(x, y, radius, massNew);
		setFillColor(Color.YELLOW)
	}
	
	//Methods
	
	public int getConsumed() {
		return consumed;
	}
	
	public boolean isNova() {
		return nova;
	}
	
	private boolean goNova() {
		if (consumed > 5) {
			isNova = true;
		}
	}
	
}