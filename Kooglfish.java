
public class Kooglfish extends Marinelife implements Looks {
	
	public Kooglfish(String name, int[] position) {
		super();
		this.setName(name);
		this.setPosition(position);
		this.setVertSpeed(0);
		int	randomDirection = (int)((Math.random()-1)*2);
		if (randomDirection < 0 ) { 
			this.setHorizSpeed(-1); 
			} else {
			this.setHorizSpeed(1);
			}
		this.setChangeDepthProbability(0.1);
		setOrientation();
	}
	
	@Override
	public void setOrientation () {
		if (this.getHorizSpeed() < 0) {
		this.setBody(new char [] {'<', '(', ')', '>', '<'});
		}
		else {
		this.setBody(new char [] {'>', '<', '(', ')', '>'});
		}
	}

}
