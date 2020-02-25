import java.util.ArrayList;
import java.util.List;

public class Bowl {

	private int width;	
	private int depth;

	public Bowl (int width, int depth) {
	 this.width = width;
	 this.depth = depth;
	}
	
	public int getWidth() {
		return width;
	}

	public int getDepth() {
		return depth;
	}
	
	public void setWidth (int width) {
		this.width = width;
	}
	
	public void setDepth (int depth) {
		this.depth = depth;
	}
	
	public List<Fish> makeSwarm (int BOWLWIDE, int BOWLDEEP){
		
		int horizPosition = BOWLWIDE -2 ;
		int vertPosition = BOWLDEEP;
		int [][] positions = new int [4][2];
		
		for (int i = 0; i < positions.length; i++) {
		horizPosition = (int) (Math.random() * (BOWLWIDE - 4));
		vertPosition = (int) (Math.random () * (BOWLDEEP));
		positions[i][0] = horizPosition;
		positions[i][1] = vertPosition; 
		}
	
		List<Fish>swarm = new ArrayList <Fish>();
		
		for (int i = 0; i < positions.length; i++) {
		swarm.add(new Fish (String.valueOf(i), positions[i]));
		}
		return swarm;
	}

}
