import java.awt.Color;

public abstract class SStar extends SObject {

	/**
	*Class for Stars
	*
	*Runner class responsibilities:
	*
	*/
	
	//Instance Variables
	private int consumed;
	private boolean nova = false;
	
	public SStar(int x, int y, double radius, long massNew){
		super(x, y, radius, massNew, 0, 0);
		setFillColor(Color.YELLOW);
	}
	
	//Methods
	
	public int getConsumed() {
		return consumed;
	}
	
	public boolean isNova() {
		return nova;
	}
	
	private boolean checkGoNova() {
		if (consumed > 5) {
			nova = true;
		} else {
			nova = false;
		}
		return nova;
	}
	
	public void act(){
		actForces();
		checkGoNova();
	}
	
}