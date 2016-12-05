package scores; 

/**
 * The Scorecard holds a list of score objects. * 
 * All method to get and set score objects are called through the Scorecard.
 * The Scorecard also keeps track of and provides methods to retrieve totals and bonuses.
 * 
 * @author Michael McCulley and Michelle Capriles-Escobedo
 *
 */
public class Scorecard {
	// Names for the indexes (also referred to as scoreType) of the score elements in the scores array.
	public static final int ONES = 0;
	public static final int TWOS = 1;
	public static final int THREES = 2;
	public static final int FOURS = 3;
	public static final int FIVES = 4;
	public static final int SIXES = 5;
	public static final int THREE_OF_A_KIND = 6;
	public static final int FOUR_OF_A_KIND = 7;
	public static final int FULL_HOUSE = 8;
	public static final int SMALL_STRAIGHT = 9;
	public static final int LARGE_STRAIGHT = 10;
	public static final int YAHTZEE = 11;
	public static final int CHANCE = 12;
	
	// Bonus if upper section totals >= 63.
	private static final int UPPER_SECTION_BONUS = 35;

	// Array of score objects.
	private Score[] scores;
	private int yahtzeeBonusCount;

	/**
	 * The constructor essentially just sets up the array of score objects.
	 * Each score is specific instance of the abstract class, Score.java.
	 */
	public Scorecard() {
		scores = new Score[13];
		scores[ONES] = new OnesScore();
		scores[TWOS] = new TwosScore();
		scores[THREES] = new ThreesScore();
		scores[FOURS] = new FoursScore();
		scores[FIVES] = new FivesScore();
		scores[SIXES] = new SixesScore();
		scores[THREE_OF_A_KIND] = new ThreeOfAKindScore();
		scores[FOUR_OF_A_KIND] = new FourOfAKindScore();
		scores[FULL_HOUSE] = new FullHouseScore();
		scores[SMALL_STRAIGHT] = new SmallStraightScore();
		scores[LARGE_STRAIGHT] = new LargeStraightScore();
		scores[YAHTZEE] = new YahtzeeScore();
		scores[CHANCE] = new ChanceScore();
	}

	/**
	 * This method will evaluate a set of passed dice for a passed scoreType.
	 * Based on whether joker rules apply, the Score object's appropriate evaluate method is called.
	 * 
	 * @param dice
	 * @param scoreType
	 * @return
	 */
	public int evaluate(int[] dice, int scoreType) {
		// If joker rules apply, call that evaluate method.
		if (jokerRulesApplicable(dice)) return scores[scoreType].evaluateJokerRules(dice);
		else if (isYahtzee(dice) && scores[YAHTZEE].isPopulated()) {
			// It's a yahtzee and yahtzee score is populated.
			// However, the appropriate upper section is not populated.
			// Because of the indexing of the scoreTypes, dice[0]-1 is the upper section index (scoreType).
			// According to joker rules, if the upper section is not populated, it must be played.
			// Everything else evaluate the zero.
			if (scoreType == (dice[0]-1)) return scores[scoreType].evaluate(dice);
			else return 0;
		}
		// Otherwise, we just return a basic evaluation for each score object.
		else return scores[scoreType].evaluate(dice);
	}
		
	/**
	 *  We call the setScore and pass to the score whether or not joker rules apply.
	 *  If we have a yahtzee and yahtzee has already been played for 50 points, we increment the bonus counter.
	 *  
	 * @param dice
	 * @param scoreType
	 */
	public void setScore(int[] dice, int scoreType){
		if (isYahtzee(dice) && scores[YAHTZEE].getPoints() > 0) yahtzeeBonusCount++;
		scores[scoreType].setScore(dice,jokerRulesApplicable(dice));	
		
	}
	
	/**
	 * Return the points for a score type.
	 * 
	 * @param scoreType
	 * @return
	 */
	public int getPoints(int scoreType) {
		return scores[scoreType].getPoints();
	}
	
	/**
	 * Return if the score has been played.
	 * 
	 * @param scoreType
	 * @return
	 */
	public boolean isPopulated(int scoreType) {
		return scores[scoreType].isPopulated();
	}
	
	/**
	 * Determines if the dice are a yahtzee.
	 * 
	 * @param dice
	 * @return
	 */
	private boolean isYahtzee(int[] dice) {  
		return (dice[0] == dice[1] && dice[0] == dice[2] && dice[0] == dice[3]
				&& dice[0] == dice[4]);
	}			

	/**
	 * Determines if joker rules apply.
	 * 
	 * @param dice
	 * @return
	 */
	private boolean jokerRulesApplicable(int[] dice) {
		// Joker rules will apply if the appropriate upper section is populated
		// Due to the order of scores[] array, (dice[0] - 1) corresponds to the correct index.
		if (isYahtzee(dice) && scores[YAHTZEE].isPopulated()) return (scores[dice[0] - 1].isPopulated());
		else return false;
	}
	
	/**
	 * Returns the a sum of current points.
	 * 
	 * @return
	 */
	public int getTotalPoints() {
		int totalPoints = 0;
		for (int i = 0; i < 13; i++) {
			totalPoints += scores[i].getPoints();
		}
		totalPoints += 100 * yahtzeeBonusCount;
		totalPoints += getUpperSectionBonus();
		return totalPoints;
	}
	
	/**
	 * Returns the sum of the upper section.
	 * 
	 * @return
	 */
	public int getUpperSectionPoints() {
		int totalPoints = 0;
		for (int i = 0; i < 6; i++) {
			totalPoints += scores[i].getPoints();
		}
		return totalPoints;
	}
	
	/**
	 * Returns a bonus of 35 points if the upper section is >= 63.
	 * 
	 * @return
	 */
	public int getUpperSectionBonus() {
		if (scores[ONES].getPoints() + scores[TWOS].getPoints() + scores[THREES].getPoints()
				+ scores[FOURS].getPoints() + scores[FIVES].getPoints() + scores[SIXES].getPoints() >= 63)
		return UPPER_SECTION_BONUS;
		else return 0;
	}
	
	/**
	 * Returns the yahtzee bonus count.
	 * 
	 * @return
	 */
	public int getYahtzeeBonusCount() {
		return yahtzeeBonusCount;
	}
	
}
