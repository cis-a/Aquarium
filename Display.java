
public class Display {

	private int width;	
	private int depth;
	
	public Display (int width, int depth) {
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
		final int BOTTOMINDEX= depth;
		final int LEFTINDEX = 0;
		final int RIGHTINDEX= width +1;
		
//	To paint each box:
		for (int box = LEFTINDEX+1; box < RIGHTINDEX; box ++){
			for (int level = 0; level < BOTTOMINDEX; level++) {
				aquariumArea[level][LEFTINDEX]='|';
				aquariumArea[level][box]=' ';
				aquariumArea[level][RIGHTINDEX]='|';
			}
		}
		aquariumArea[BOTTOMINDEX][LEFTINDEX] = '+';
		for (int bottom = 1; bottom <= width ; bottom++) {
			aquariumArea[BOTTOMINDEX][bottom] = '-';
		}
		aquariumArea[BOTTOMINDEX][RIGHTINDEX] = '+';
		return aquariumArea;
	}
	
}
