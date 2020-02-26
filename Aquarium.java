import java.util.List;

public class Aquarium {
	
	public static void main(String[] args) throws InterruptedException{
		
		final int BOWLWIDE = 60;
		final int BOWLDEEP = 15;
		final int LIFEFORMS = 7;
		
		Bowl myFishBowl = new Bowl (BOWLWIDE, BOWLDEEP);
		Display myDisplay = new Display(BOWLWIDE+2, BOWLDEEP+1);
		
		char[][] myPicture = myDisplay.paintBowl(myFishBowl);
		
		List<Marinelife>marinelife = myFishBowl.makeMarinelife(BOWLWIDE, BOWLDEEP, LIFEFORMS);
		
		for (Marinelife marine : marinelife) {
			marine.placeMarinelife(myPicture);
		}
	
		myDisplay.renderPicture(myPicture);
	
		while (true) {
			Thread.sleep(150,0);
			myPicture = myDisplay.paintBowl(myFishBowl);
			for (Marinelife marine : marinelife) {
				marine.move(myFishBowl);
				// Wenn Hai und anderer Fisch an gleicher Position sind + gleiche Bewegungsrichtung, dann nimm den anderen Fisch aus der Liste
				
				marine.placeMarinelife(myPicture);
			}
			myDisplay.renderPicture(myPicture);
		}
	}
}

