package scores;

/**
 * @author Bradley Hickey
 */
public class FullHouseScore extends Score{

	private final int diecount = 3;
	private final int diecount2 = 2;
	private final int fullhousepoints = 25;
	
	@Override
	//Evaluates the dice array for Full House score
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

		if((onescount == diecount && twoscount == diecount2) || 
				(onescount == diecount && threescount == diecount2) || 
				(onescount == diecount && fourscount == diecount2) || 
				(onescount == diecount && fivescount == diecount2) || 
				(onescount == diecount && sixescount == diecount2))
			points = fullhousepoints;

		if((twoscount == diecount && onescount == diecount2) || 
				(twoscount == diecount && threescount == diecount2) || 
				(twoscount == diecount && fourscount == diecount2) || 
				(twoscount == diecount && fivescount == diecount2) || 
				(twoscount == diecount && sixescount == diecount2))
			points = fullhousepoints;  	 

		if((threescount == diecount && onescount == diecount2) || 
				(threescount == diecount && twoscount == diecount2) || 
				(threescount == diecount && fourscount == diecount2) || 
				(threescount == diecount && fivescount == diecount2) || 
				(threescount == diecount && sixescount == diecount2))
			points = fullhousepoints;   	 

		if((fourscount == diecount && onescount == diecount2) || 
				(fourscount == diecount && threescount == diecount2) || 
				(fourscount == diecount && twoscount == diecount2) || 
				(fourscount == diecount && fivescount == diecount2) || 
				(fourscount == diecount && sixescount == diecount2))
			points = fullhousepoints;    	 

		if((fivescount == diecount && onescount == diecount2) || 
				(fivescount == diecount && threescount == diecount2) || 
				(fivescount == diecount && fourscount == diecount2) || 
				(fivescount == diecount && twoscount == diecount2) || 
				(fivescount == diecount && sixescount == diecount2))
			points = fullhousepoints;   	 

		if((sixescount == diecount && onescount == diecount2) || 
				(sixescount == diecount && threescount == diecount2) || 
				(sixescount == diecount && fourscount == diecount2) || 
				(sixescount == diecount && fivescount == diecount2) || 
				(sixescount == diecount && twoscount == diecount2))
			points = fullhousepoints;    	 



		return points;
	}//end evaluate

	//Returns a string of the score name
	public String toString() {
		return "FullHouse";
	}//end toString

	//Returns the points if joker rules apply
	@Override
	public int evaluateJokerRules(int[] dice) {

		return fullhousepoints;
	}//end evaluateJokerRules

}