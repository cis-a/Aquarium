
public class Fish extends Marinelife {
	
	public Fish(String name, int[] position) {
		super();
		this.setName(name);
		this.setPosition(position);
		this.setVertSpeed(0);
		this.setHorizSpeed(1);
		char [] body = {'>', '<', '>'};
		this.setBody(body);
	}
	
	@Override
	public void move (Bowl bowl) {

		int vertSpeed = this.getVertSpeed();
		int horizSpeed = this.getHorizSpeed();
		
		if (this.getPosition()[0] + this.getBody().length + horizSpeed > bowl.getWidth() 
				|| this.getPosition()[0] + horizSpeed <= 1 ) {
			// reverse direction by inverting Speed
			reverseMove();			
			setOrientation();
		}
		if (this.getPosition()[1] +vertSpeed > bowl.getDepth()
				|| this.getPosition()[1] + vertSpeed < 0 ) {
			this.setVertSpeed(-vertSpeed);
		}
		int [] position = {this.getPosition()[0] + horizSpeed, this.getPosition()[1] + vertSpeed};
		this.setPosition (position);
	}
	
	@Override
	public char [][] placeMarinelife (char[][] area) {
		
		int [] position = this.getPosition();
			for (int i = 0 ; i < this.getBody().length; i++) {
			area[position[1]][position[0]+i] = this.getBody()[i]; 
			}
	return area;
	}
	
	//probably obsolete / replaced by placeMarinelife
	public char [][] placeFish (char[][] area) {
		
		int [] position = this.getPosition();
			for (int i = 0 ; i < this.getBody().length; i++) {
			area[position[1]][position[0]+i] = this.getBody()[i]; 
			}
	return area;
	}

	public void reverseMove () {
		this.setHorizSpeed(-this.getHorizSpeed());
		}
	
	public void setOrientation () {
		if (this.getHorizSpeed() < 0) {
		this.setBody(new char [] {'<', '>', '<'});
		}
		else {
		this.setBody(new char [] {'>', '<', '>'});
		}
	}
	
}
