package scores;

/**
 * @author Bradley Hickey
 */
public class FivesScore  extends Score{

	@Override
	//Evaluates the dice array for Fives score
	public int evaluate(int[] dice) {
		if (isPopulated) throw new DuplicateScoreException(this.toString());
		
		int points = 0;
		for (int i: dice) {
			if (i==5) points += 5;
		}//end for
		return points;
	}//end evaluate

	//Returns a string of the score name
	public String toString() {
		return "Fives";
	}//end toString

	//Returns the points if joker rules apply
	@Override
	public int evaluateJokerRules(int[] dice) {
		return evaluate(dice);
	}//end evaluateJokerRules
}
