import java.util.ArrayList;
import java.util.List;

public class Aquarium {
	
	public static void main(String[] args) throws InterruptedException{
		
		final int BOWLWIDE = 60;
		final int BOWLDEEP = 10 ;
		
		Bowl myFishBowl = new Bowl (BOWLWIDE, BOWLDEEP);
		Screen myViewport = new Screen(BOWLWIDE+2, BOWLDEEP+1);
		
		char[][] myScreen = myViewport.paintBowl(myFishBowl);
		
		List<Fish>swarm = myFishBowl.makeSwarm(BOWLWIDE, BOWLDEEP);
		
		for (Fish fish : swarm) {
			fish.placeFish(myScreen);
		}
	
		myViewport.renderPicture(myScreen);
	
		while (true) {
			
			Thread.sleep(100,0);
			myScreen = myViewport.paintBowl(myFishBowl);
			for (Fish fish : swarm) {
				fish.move(myFishBowl);
				fish.placeFish(myScreen);
			}

			myViewport.renderPicture(myScreen);
		}
	}
}

