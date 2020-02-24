package Aquarium;

public class Aquarium {
	
	public static void main(String[] args) {

		Screen myViewport = new Screen();
		Bowl myFishBowl = new Bowl (30, 4);
		
		char[][] myScreen = myViewport.paintBowl(myFishBowl);
		
		int [] position1 = { 10, 1}; 
		int [] position2 = { 22, 0 };
		int [] position3 = { 5, 2 };
		int [] position4 = { 15, 3 };
		Fish nemo = new Fish ("Nemo", position1);
		Fish abe = new Fish ("Abe", position2);
		Fish bob = new Fish ("Bob", position3);
		Fish clark = new Fish ("Clark", position4);
		nemo.placeFish(myScreen);
		abe.placeFish(myScreen);
		bob.placeFish(myScreen);
		clark.placeFish(myScreen);
		myViewport.renderPicture(myScreen);
	
	for (int i= 1; i < 50; i++) {
		nemo.move(myFishBowl);
		abe.move(myFishBowl);
		bob.move(myFishBowl);
		clark.move(myFishBowl);
		myScreen = myViewport.paintBowl(myFishBowl);
		nemo.placeFish(myScreen);
		abe.placeFish(myScreen);
		bob.placeFish(myScreen);
		clark.placeFish(myScreen);
		myViewport.renderPicture(myScreen);
		}
	}
}

