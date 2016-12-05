package scores;

/**
 * @author Bradley Hickey
 */
public class LargeStraightScore extends Score{


	private final int diecount = 1;
	private final int largestraightscore =40;
	
	//Evaluates the dice array for Large Straight score
	@Override
	public int evaluate(int[] dice) {
		if (isPopulated) throw new DuplicateScoreException(this.toString());

		int points = 0;
		int onescount =0;
		int twoscount =0;
		int threescount =0;
		int fourscount =0;
		int fivescount =0;
		int sixescount =0;
		for (int i: dice) {
			if (i==1) onescount++;
			if (i==2) twoscount++;
			if (i==3) threescount++;		   	 
			if (i==4) fourscount++;		   	 
			if (i==5) fivescount++;		   	 
			if (i==6) sixescount++;		   	 
		}//end for	 



		if((onescount >= diecount && twoscount >= diecount && threescount >= diecount && fourscount >= diecount && fivescount >= diecount) || 
				(twoscount >= diecount && threescount >= diecount && fourscount >= diecount && fivescount >= diecount && sixescount >= diecount))
			points = largestraightscore;


		return points;
	}//end evaluate

	//Returns a string of the score name
	public String toString() {
		return "Large Straight";
	}//end toString

	//Returns the points if joker rules apply
	@Override
	public int evaluateJokerRules(int[] dice) {
		return largestraightscore;
	}//end evaluateJokerRules
}