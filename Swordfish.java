
public class Swordfish extends Marinelife implements Swim {
	
	public Swordfish(String name, int[] position) {
		super();
		this.setName(name);
		this.setPosition(position);
		this.setVertSpeed(0);
		this.setHorizSpeed(-2);
		char [] body = {'-', '<', '>', '<'};
		this.setBody(body);
	}
	
	@Override
	public void move (Bowl bowl) {

		changeDepthProbability(0.2);
		int [] position = {this.getPosition()[0], this.getPosition()[1]};
		decideOnTurn(bowl);
		position [1] = updateDepth(bowl);
		position [0] = updateWidth(bowl);

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
	
	@Override
	public void setOrientation () {
		if (this.getHorizSpeed() < 0) {
		this.setBody(new char [] {'-', '<', '>', '<'});
		}
		else {
		this.setBody(new char [] {'>', '<', '>', '-'});
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
	
	@Override
	public void decideOnTurn (Bowl bowl) {
		if (this.getPosition()[0] + this.getBody().length + this.getHorizSpeed() > bowl.getWidth()) {
			this.setHorizSpeed(-this.getHorizSpeed());			
			setOrientation();
		} else if (this.getPosition()[0] + this.getHorizSpeed() <= 1) {
			this.setHorizSpeed(-this.getHorizSpeed());			
			setOrientation();
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
		} else return this.getPosition()[1] + this.getVertSpeed();
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
