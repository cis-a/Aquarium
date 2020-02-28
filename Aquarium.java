import java.util.Arrays;
import java.util.List;

public class Aquarium {
	
	public static void main(String[] args) throws InterruptedException{
		
		final int BOWLWIDE = 60;
		final int BOWLDEEP = 15;
		final int LIFEFORMS = 8;
		final int HAIINDEX = 0;
		
		Bowl myFishBowl = new Bowl (BOWLWIDE, BOWLDEEP);
		Display myDisplay = new Display(BOWLWIDE+2, BOWLDEEP+1);
		
		char[][] myPicture = myDisplay.paintBowl(myFishBowl);
		
		List<Marinelife>marinelife = myFishBowl.makeMarinelife(BOWLWIDE, BOWLDEEP, LIFEFORMS);
		
		for (Marinelife marine : marinelife) {
			marine.placeMarinelife(myPicture);
		}
	
		myDisplay.renderPicture(myPicture);
	
		while (marinelife.size() > 1) {
			Thread.sleep(150,0);
			myPicture = myDisplay.paintBowl(myFishBowl);
			for (Marinelife marine : marinelife) {
				marine.move(myFishBowl);
			}
			marinelife.get(HAIINDEX).feed(marinelife, HAIINDEX);
			for (Marinelife marine : marinelife) {
			marine.placeMarinelife(myPicture);
			}
			myDisplay.renderPicture(myPicture);
			System.out.println("Hai feeding score: "  + marinelife.get(HAIINDEX).getFeedCounter() );
		}
	}
}

