

public class Bowl {

	private int width;	
	private int depth;

	public Bowl (int width, int depth) {
	 this.width = width;
	 this.depth = depth;
	}
	
	public int getWidth() {
		return width;
	}

	public int getDepth() {
		return depth;
	}
	
	public void setWidth (int width) {
		this.width = width;
	}
	
	public void setDepth (int depth) {
		this.depth = depth;
	}

	public char[][] showOutline (int width, int depth){
		
//		depth = this.getDepth();
//		System.out.println(width);
//		width = this.getWidth();
//		System.out.println(width);
		//char[][] aquariumArea = new char [this.getDepth() + 1][this.getWidth()+2];
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
