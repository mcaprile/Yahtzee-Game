package scores;

/**
 * @author Bradley Hickey
 */
public class FoursScore  extends Score{

	@Override
	//Evaluates the dice array for Fours score
	public int evaluate(int[] dice) {
		if (isPopulated) throw new DuplicateScoreException(this.toString());
		
		int points = 0;
		for (int i: dice) {
			if (i==4) points += 4;
		}//end for
		return points;
	}//end evaluate
	
	//Returns a string of the score name
	public String toString() {
		return "Fours";
	}//end toString

	@Override
	//Returns the points if joker rules apply
	public int evaluateJokerRules(int[] dice) {
		return evaluate(dice);
	}//end evaluateJokerRules
}
