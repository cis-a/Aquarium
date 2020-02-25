
public class Kooglfish extends Marinelife {
	
	public Kooglfish(String name, int[] position) {
		super();
		this.setName(name);
		this.setPosition(position);
		this.setVertSpeed(0);
		this.setHorizSpeed(1);
		char [] body = {'>', '<', '(', ')', '>'};
		this.setBody(body);
	}
	
	@Override
	public void move (Bowl bowl) {

		changeDepthProbability(0.1);
		int vertSpeed = this.getVertSpeed();
		int horizSpeed = this.getHorizSpeed();
		int [] position = {this.getPosition()[0], this.getPosition()[1]};
		int horizTip = position[0] + this.getBody().length;	
		
		if (horizTip + horizSpeed > bowl.getWidth()) {
			this.setHorizSpeed(-horizSpeed);			
			setOrientation();
		} else if (position[0] + horizSpeed <= 1) {
			this.setHorizSpeed(-horizSpeed);			
			setOrientation();
		}
		
		if (position[1] + vertSpeed >= bowl.getDepth()) {
			this.setVertSpeed(-vertSpeed);
			position [1] = bowl.getDepth() -1 ;
		} else if (position[1] + vertSpeed <= 0) {
			this.setVertSpeed(-vertSpeed);
			position [1] = 1;
		}			
	
		if (horizTip + horizSpeed > bowl.getWidth()) {
				position [0] = position[0] + horizSpeed - this.getBody().length;
			} else if (position[0] + horizSpeed < 1 ) {
				position [0] = 1;
			} else { position [0]  = position[0] + horizSpeed;
		}
		
		if (position[1] + vertSpeed > bowl.getDepth()) {
			position [1] = bowl.getDepth();
			} else if (position [1] < 0) {
			position[1] = 0;
			} else {
			position [1] = position[1] + vertSpeed;
		}
		this.setVertSpeed(0);
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
		this.setBody(new char [] {'<', '(', ')', '>', '<'});
		}
		else {
		this.setBody(new char [] {'>', '<', '(', ')', '>'});
		}
	}
	
	@Override
	public void changeDepthProbability(double probability) {
		double chance = (Math.random() * 2) - 1; 
		if (chance <= -1 + probability) {
			this.setVertSpeed(-1);
		} else if (chance >= 1 - probability) {
			this.setVertSpeed(1);
		}
		
	}
}
