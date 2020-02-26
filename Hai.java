
public class Hai extends Marinelife implements Looks {
	
	public Hai(String name, int[] position) {
		super();
		this.setName(name);
		this.setPosition(position);
		this.setVertSpeed(0);
		this.setHorizSpeed(-3);
		this.setChangeDepthProbability(0.25);
		setOrientation();
	}
	
	@Override
	public void setOrientation () {
		if (this.getHorizSpeed() < 0) {
		this.setBody(new char [] {'<', '/', '/', '/', '=','=','=','=', '>', '<'});
		}
		else {
		this.setBody(new char [] {'>', '<', '=','=','=','=', '\\','\\','\\', '>'});
		}
	}
			
}
