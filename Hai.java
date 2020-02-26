import java.util.Arrays;
import java.util.List;

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
	
	@Override			
	public void feed (List <Marinelife> marinelife, int HAIINDEX) {
		int jaws = marinelife.get(HAIINDEX).getPosition()[0];
		int jawsRange = 1;
		boolean swimSameDirection;
		for (int i = 1; i < marinelife.size(); i++) {
			if (marinelife.get(HAIINDEX).getPosition()[1]== marinelife.get(i).getPosition()[1]) {
				swimSameDirection = jawsRange * marinelife.get(HAIINDEX).getHorizSpeed() > 0;
				if (marinelife.get(i).getHorizSpeed() > 0 ) {
					jawsRange = 1;
				} else { 
					jawsRange = -1;
				}
				if ( jaws == marinelife.get(i).getPosition()[0] 
						|| jaws == marinelife.get(i).getPosition()[0]+ jawsRange && swimSameDirection
						|| jaws == marinelife.get(i).getPosition()[0]+ (2*jawsRange) && swimSameDirection){
				marinelife.remove(i);
				}
			}
		}
	}
			
}
