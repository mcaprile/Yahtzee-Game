package scores;

/**
 * @author Bradley Hickey
 */
public class FourOfAKindScore extends Score{

	private final int diecount = 4;
	
	@Override
	//Evaluates dice array for Four of a Kind
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

		}//End for	 

		if(onescount >= diecount || twoscount >= diecount || threescount >= diecount || fourscount >= diecount
				|| fivescount >= diecount || sixescount >= diecount)
			for (int i: dice) points = points + i;

		return points;
	}//end evaluation

	//Returns a string of the score name
	public String toString() {
		return "Four of a Kind";
	}


	@Override
	//Returns the points if joker rules apply
	public int evaluateJokerRules(int[] dice) {
		return evaluate(dice);
	}//end evaluateJokerRules

}
