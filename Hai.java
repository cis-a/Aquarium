import java.util.List;

public class Hai extends Marinelife implements Looks {

	public Hai(String name, int[] position) {
		super();
		this.setName(name);
		this.setPosition(position);
		this.setVertSpeed(0);
		int	randomDirection = (int)((Math.random()-1)*2);
			if (randomDirection < 0 ) { 
				this.setHorizSpeed(-3); 
				} else {
				this.setHorizSpeed(3);
				}
		this.setChangeDepthProbability(0.25);
		this.setFeedCounter(0);
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
		if (this.getFeedCounter() > 0 ) {
			grow ();
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
					jawsRange = -1;
				} else { 
					jawsRange = 1;
				}
				if ( jaws == marinelife.get(i).getPosition()[0] 
						|| jaws == marinelife.get(i).getPosition()[0]+ jawsRange && swimSameDirection
						|| jaws == marinelife.get(i).getPosition()[0]+ (2*jawsRange) && swimSameDirection){
				marinelife.remove(i);
				this.setFeedCounter (this.getFeedCounter() + 1);
				this.setOrientation();
				}
			}
		}
	}
	
	public void grow () {
		char [] fedHai = new char [ this.getBody().length + this.getFeedCounter() ];
		int j = 0;
			while ( j < fedHai.length) {
				if ( j < 4 ) {
				 fedHai[j] = this.getBody()[j];
				}else if (j == 4) {
					for (int i =0 ; i <= this.getFeedCounter(); i++) {
					fedHai[j+i] = '=';
					}
					j += (this.getFeedCounter()-1);
				} else {
					fedHai[ j ] = this.getBody() [ j - this.getFeedCounter() ];
				}
			j++;
			}
		this.setBody(fedHai);
	}
			
}
