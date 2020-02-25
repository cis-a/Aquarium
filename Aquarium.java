
public class Aquarium {
	
	public static void main(String[] args) throws InterruptedException{
		
		final int AQUAWIDE = 30;
		final int AQUADEEP = 4;
		
		Bowl myFishBowl = new Bowl (AQUAWIDE, AQUADEEP);
		Screen myViewport = new Screen(AQUAWIDE+2, AQUADEEP+1);
		
		char[][] myScreen = myViewport.paintBowl(myFishBowl);
		
		int [] position1 = { 10, 1}; 
		int [] position2 = { 22, 0 };
		int [] position3 = { 5, 2 };
		int [] position4 = { 15, 3 };
		
		Fish abe = new Fish ("Abe", position2);
		Fish bob = new Fish ("Bob", position3);
		Fish clark = new Fish ("Clark", position4);
		Fish devo = new Fish ("Devo", position1);
		
		abe.placeFish(myScreen);
		bob.placeFish(myScreen);
		clark.placeFish(myScreen);
		devo.placeFish(myScreen);
		
		myViewport.renderPicture(myScreen);
	
		while (true) {
			
			Thread.sleep(100,0);
			devo.move(myFishBowl);
			abe.move(myFishBowl);
			bob.move(myFishBowl);
			clark.move(myFishBowl);
			myScreen = myViewport.paintBowl(myFishBowl);
			devo.placeFish(myScreen);
			abe.placeFish(myScreen);
			bob.placeFish(myScreen);
			clark.placeFish(myScreen);
			myViewport.renderPicture(myScreen);
		}
	}
}

