package scores; 

/**
 * This is the abstract class for Score objects.
 * 
 * @author Mike McCulley
 *
 */
public abstract class Score {
	// Keeps track if the score has been played.
	protected boolean isPopulated;
	// This is the current points on the score.
	protected int points;
	
	//The evaluate methods are abstract and specific to each score type.
	//Each score type will have a standard evaluation and a joker rules evaluation.
	public abstract int evaluate(int[] dice);
	public abstract int evaluateJokerRules(int[] dice);

	//Set score calls the appropriate evaluate method depending on joker rules and sets the points.
	public void setScore(int[] dice, boolean jokerRulesApplicable) {
		if (isPopulated)
			throw new DuplicateScoreException(this.toString());
		
		if (jokerRulesApplicable) points = evaluateJokerRules(dice);
		else points = evaluate(dice);
		
		isPopulated = true;
	}
	
	/**
	 * Getter for isPopulated.
	 */
	public boolean isPopulated() {
		return isPopulated;
	}

	/**
	 * Getter for the points.
	 * @return
	 */
	public int getPoints() {
		return points;
	}

}