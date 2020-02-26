
public class Fish extends Marinelife implements Swim {
	
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
	
	@Override
	public void setOrientation () {
		if (this.getHorizSpeed() < 0) {
		this.setBody(new char [] {'<', '>', '<'});
		}
		else {
		this.setBody(new char [] {'>', '<', '>'});
		}
	}
	
	@Override
	public int updateDepth (Bowl bowl) {
		if (this.getPosition()[1] + this.getVertSpeed() >= bowl.getDepth()) {
			this.setVertSpeed(-this.getVertSpeed());
			return bowl.getDepth() -1 ;
		} else if (this.getPosition()[1] + this.getVertSpeed() <= 0) {
			this.setVertSpeed(-this.getVertSpeed());
			return 1;
		} else return this.getPosition()[1];
	}
	
	@Override
	public int updateWidth (Bowl bowl) {
		int horizTip = this.getPosition()[0] + this.getBody().length;	
		if (horizTip + this.getHorizSpeed() > bowl.getWidth()) {
			return this.getPosition()[0] + this.getHorizSpeed() - this.getBody().length;
		} else if (this.getPosition()[0] + this.getHorizSpeed() < 1 ) {
			return 1;
		} else return this.getPosition()[0] + this.getHorizSpeed();
	}
	
}
