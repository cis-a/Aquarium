
public abstract class Marinelife {


	private String name;
	private char[] body;
	private int [] position;
	private int vertSpeed;
	private int horizSpeed;
		
	public void move (Bowl bowl) {
	}
	
	public char [][] placeMarinelife (char[][] area) {
		return area;
	}
	
	public void changeDepthProbability (double probability) {
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char[] getBody() {
		return body;
	}

	public void setBody (char[] body) {
		this.body = body;
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

	public int getHorizSpeed() {
		return horizSpeed;
	}

	public void setHorizSpeed(int horizSpeed) {
		this.horizSpeed = horizSpeed;
	}

	public int getVertSpeed() {
		return vertSpeed;
	}

	public void setVertSpeed(int vertSpeed) {
		this.vertSpeed = vertSpeed;
	}; 
	
}
