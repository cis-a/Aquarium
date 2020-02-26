
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
	
	public void setOrientation () {
	}
	
	public void changeDepthProbability(double probability) {
		double chance = (Math.random() * 2) - 1; 
		if (chance <= -1 + probability) {
			this.setVertSpeed(-1);
		} else if (chance >= 1 - probability) {
			this.setVertSpeed(1);
		}
	}
	
	public void decideOnTurn (Bowl bowl) {
		if (this.getPosition()[0] + this.getBody().length + this.getHorizSpeed() > bowl.getWidth()) {
			this.setHorizSpeed(-this.getHorizSpeed());			
			setOrientation();
		} else if (this.getPosition()[0] + this.getHorizSpeed() <= 1) {
			this.setHorizSpeed(-this.getHorizSpeed());			
			setOrientation();
		}
	}
		
	public int updateDepth (Bowl bowl) {
		if (this.getPosition()[1] + this.getVertSpeed() >= bowl.getDepth()) {
			this.setVertSpeed(-this.getVertSpeed());
			return bowl.getDepth() -1 ;
		} else if (this.getPosition()[1] + this.getVertSpeed() <= 0) {
			this.setVertSpeed(-this.getVertSpeed());
			return 1;
		} else return this.getPosition()[1] + this.getVertSpeed();
	}
	
	public int updateWidth (Bowl bowl) {
		int horizTip = this.getPosition()[0] + this.getBody().length;	
		if (horizTip + this.getHorizSpeed() > bowl.getWidth()) {
			return this.getPosition()[0] + this.getHorizSpeed() - this.getBody().length;
		} else if (this.getPosition()[0] + this.getHorizSpeed() < 1 ) {
			return 1;
		} else return this.getPosition()[0] + this.getHorizSpeed();
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
	}
	
}
