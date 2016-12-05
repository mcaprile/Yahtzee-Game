package scores;

/**
 * @author Bradley Hickey
 */
public class ThreesScore extends Score{
	
	@Override
	//Evaluates the dice array for Threes score
	public int evaluate(int[] dice) {
		if (isPopulated) throw new DuplicateScoreException(this.toString());

		int points = 0;
		for (int i: dice) {
			if (i==3) points += 3;
		}//end for
		return points;
	}//end evaluate
	
	//Returns a string of the score name
	public String toString() {
		return "Threes";
	}//end toString
	
	//Returns the points if joker rules apply
	@Override
	public int evaluateJokerRules(int[] dice) {
		return evaluate(dice);
	}//end evaluateJokerRules
}
