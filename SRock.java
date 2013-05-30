import java.awt.Color;

public class SRock extends SObject{
	
	public SRock(int x, int y, double radius, long newMass){
		super(x, y, radius, newMass, 0, 0);
		setColor(Color.DARK_GRAY);
	}
	
}