package scores;

/**
 * @author Bradley Hickey
 */
public class ChanceScore extends Score{

	
	//Evaluates the dice array for Chance score
	@Override
	public int evaluate(int[] dice) {
		if (isPopulated) throw new DuplicateScoreException(this.toString());
		
		int points = 0;
		for (int i: dice) points = points + i;
		return points;
	}//end evaluate

	//Returns a string of the score name
	public String toString() {
		return "Chance";
	}//end toString

	//Returns the points if joker rules apply
	@Override
	public int evaluateJokerRules(int[] dice) {
		return evaluate(dice);
	}//end evaluateJokerRules

}
