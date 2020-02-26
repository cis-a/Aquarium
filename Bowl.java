import java.util.ArrayList;
import java.util.List;

public class Bowl {

	private int width;	
	private int depth;
	private int lifeforms;
	
	public Bowl (int width, int depth) {
	 this.width = width;
	 this.depth = depth;
	}
	
	public Bowl (int width, int depth, int lifeforms) {
		 this.width = width;
		 this.depth = depth;
		 this.lifeforms = lifeforms;
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
	
	public int[][] randomStartPositions (int BOWLWIDE, int BOWLDEEP, int LIFEFORMS) {
		int [][] positions = new int [LIFEFORMS][2];
		for (int i = 0; i < LIFEFORMS; i++) {
			positions[i][0] = (int) (Math.random() * (BOWLWIDE - 7));
			positions[i][1] = (int) (Math.random () * (BOWLDEEP));
			}
		return positions;
	}
	
	public List<Marinelife> makeMarinelife (int BOWLWIDE, int BOWLDEEP, int LIFEFORMS){
		
		int horizPosition = BOWLWIDE -2 ;
		int vertPosition = BOWLDEEP;
		int [][] positions = new int [LIFEFORMS][2];
		
		positions = randomStartPositions (BOWLWIDE, BOWLDEEP, LIFEFORMS);
	
		List<Marinelife>marinelife = new ArrayList <Marinelife>();
				
		marinelife.add(new Kooglfish ("Kooglfish" + String.valueOf(0), positions[0]));
		marinelife.add(new Hai ("Hai" + String.valueOf(1), positions[1]));
		marinelife.add(new Swordfish ("Swordfish" + String.valueOf(2), positions[2]));
		for (int counter = 3; counter < LIFEFORMS; counter ++) {
		marinelife.add(new Fish ("Fish" + String.valueOf(counter), positions[counter]));
		}
		return marinelife;
	}

}
