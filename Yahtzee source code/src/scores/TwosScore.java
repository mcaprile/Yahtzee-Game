package scores;

/**
 * @author Bradley Hickey
 */
public class TwosScore extends Score{
	
	@Override
	//Evaluates the dice array for twos score
	public int evaluate(int[] dice) {
		if (isPopulated) throw new DuplicateScoreException(this.toString());

		int points = 0;
		for (int i: dice) {
			if (i==2) points += 2;
		}//end for
		return points;
	}//end evaluate
	
	//Returns a string of the score name
	public String toString() {
		return "Twos";
	}//end toString

	//Returns the points if joker rules apply
	@Override
	public int evaluateJokerRules(int[] dice) {
		return evaluate(dice);
	}//end evaluateJokerRules
}
