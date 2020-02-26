
public class Swordfish extends Marinelife implements Looks {
	
	public Swordfish(String name, int[] position) {
		super();
		this.setName(name);
		this.setPosition(position);
		this.setVertSpeed(0);
		this.setHorizSpeed(-2);
		this.setChangeDepthProbability(0.2);
		setOrientation();
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

}
