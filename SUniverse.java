import acm.program.*;

public class SUniverse extends GraphicsProgram{
	
	public static final int APPLICATION_WIDTH = 1000;
	public static final int APPLICATION_HEIGHT = 1000;
	
	ArrayList<SObject> objs = new ArrayList<SObject>;
	
	public void init(){
		SRock rock = new SRock(500, 500, 100, 100);
		objs.add(rock);
		
		for(SObject thing : objs){
			add(thing);
		}//End for
	}
	
	public void run(){
		for(SObject thing : objs){
			thing.act();
		}
	}
	
}