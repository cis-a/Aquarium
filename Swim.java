
public interface Swim {

	void move(Bowl bowl);

	void changeDepthProbability(double probability);

	void decideOnTurn(Bowl bowl);

	int updateDepth(Bowl bowl);
	
	int updateWidth(Bowl bowl);

}