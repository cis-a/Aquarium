

public class Screen {

	private int width;	
	private int depth;
	
	public Screen (int width, int depth) {
		 this.width = width;
		 this.depth = depth;
		}

	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public void renderPicture (char[][] myScreen) {	

		// clear screen
//			for(int i = 0; i < myScreen.length; i++)
//			{
//			    System.out.println("\b");
//			}

			System.out.print("\033[H\033[2J");


		// paint picture	
			for (char[] level : myScreen){
				for (char box : level) {
				System.out.print (box);
				}
				System.out.print('\n');
			}
		}
	
	public char[][] paintBowl (Bowl bowl){
	
		int depth = bowl.getDepth();
		int width = bowl.getWidth();

		char[][] aquariumArea = new char [depth + 1][width+2];
		final int bottomIndex= depth;
		final int leftIndex = 0;
		final int rightIndex= width +1;
		
//	To paint each box:
		for (int box = leftIndex+1; box < rightIndex; box ++){
			for (int level = 0; level < bottomIndex; level++) {
				aquariumArea[level][leftIndex]='|';
				aquariumArea[level][box]=' ';
				aquariumArea[level][rightIndex]='|';
			}
		}
		aquariumArea[bottomIndex][leftIndex] = '+';
		for (int bottom = 1; bottom <= width ; bottom++) {
			aquariumArea[bottomIndex][bottom] = '-';
		}
		aquariumArea[bottomIndex][rightIndex] = '+';
		return aquariumArea;
	}
	
}
