package scores;

/**
 * @author Bradley Hickey
 */
public class OnesScore extends Score {

	//Evaluates the dice array for Ones score
	@Override
	public int evaluate(int[] dice) {
		if (isPopulated) throw new DuplicateScoreException(this.toString());

		int points = 0;
		for (int i: dice) {
			if (i==1) points += 1;
		}//end for
		return points;
	}//end evaluate

	//Returns a string of the score name
	public String toString() {
		return "Ones";
	}//end toString
	
	//Returns the points if joker rules apply
	@Override
	public int evaluateJokerRules(int[] dice) {
		return evaluate(dice);
	}//end evaluateJokerRules

}
