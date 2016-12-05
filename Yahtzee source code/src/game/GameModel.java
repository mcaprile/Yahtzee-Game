package game;
import java.util.Random;
import scores.*;

/**
 * The game model holds all of the data for the game, 
 * along with all of the logic for updating the data.
 * It also provides methods used by the UI to retrieve data for displaying
 * and also methods called by the UI to update data.
 * 
 * When a method updates the data, that method then calls GameApp.updateView()
 * to have the UI refresh itself.
 * 
 * @author Michael McCulley and Michelle Capriles-Escobedo
 *
 */
public class GameModel {
	public static final int TOTAL_ROUNDS = 13;
	public static final int MAX_ROLL = 3;

	// We keep a reference to the GameApp in order to call updateView;
	private GameApp app; 
	// Game state is used by the UI to determine what UI's to display.
	// 1 = Setup, 2 = Game In Play, 3 = Game Over (display winners)		
	private int gameState; 			 	
	// dice[] and kept[] together are the dice objets.
	// dice[] are the dice values. 
	// kept[] is whether or not the dice are held on the next roll.
	private int[] dice; 
	private boolean[] kept;
	// Self explanatory variables for game flow.
	private Player[] players;
	private int rollCount;
	private int playerCount;
	private int currentPlayerIndex;
	private int currentRound;

    /**
     * Sets a reference to the GameApp and instantiates the dice array,
     * and sets the initial game state for setup.
     * @param app
     */
	public GameModel (GameApp app) {
		this.app = app;
		kept = new boolean[5];
		dice = new int[5];
		gameState = 1;
	}

	/**
	 * This method is called from the welcome/setup UI.
	 * It is passed an array of player names.
	 * Then, it creates the player objects, updates the gameState, and initiates the game.
	 * @param playerNames
	 */
	public void setPlayers(String[] playerNames) {	
		if (playerNames.length > 0) {
			players = new Player[playerNames.length];	
			for (int i = 0; i < playerNames.length; i++) {
				players[i] = new Player(playerNames[i]);
			}
			gameState = 2;
			currentRound = 1;
			playerCount = playerNames.length;
			resetPlayerRound();
			app.updateView();
		}
	}
	/**
	 * Used by the PlayersListPanel to display names and scores.
	 * This method correlates with getScoreTotals.
	 * @return the player names
	 */
	public String[] getPlayerNames() {
		String[] names = new String[playerCount];
		for(int i = 0; i < names.length; i++) {
			names[i] = players[i].getName();
		}
		return names;
	}

	/**
	 * Used by the PlayersListPanel to display names and scores.
	 * This method correlates with getPlayerNames.
	 * @return the score totals
	 */
	public int[] getScoreTotals() {
		int[] totals = new int[playerCount];
		for(int i = 0; i < totals.length; i++) {
			totals[i] = players[i].getScorecard().getTotalPoints();
		}
		return totals;
	}


	/**
	 * Used by the PlayersListPanel to determine the current player when displaying names.
	 * The current player's name is bold.
	 * @return the current player index
	 */
	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}

	/**
	 * Used by the DicePanel to determine if a die should be kept or not.
	 * @param die
	 * @return if the current die should be kept
	 */
	public boolean isKept(int die) {
		return kept[die];
	}

	/**
	 * Used by the DicePanel to keep a die.
	 * @param die
	 * @param dieSelected
	 */
	public void keepDie(int die, boolean dieSelected) {
		if (rollCount > 0) {
			this.kept[die] = dieSelected;
			app.updateView();	
		}
	}

	/**
	 * Used by the DicePanel to display the die value.
	 * @param dieIndex
	 * @return
	 */
	public int getDieValue(int dieIndex) {
		return dice[dieIndex];
	}

	/**
	 * Used by the DicePanel to roll the dice.
	 */
	public void rollDice(){
		if (rollCount < GameModel.MAX_ROLL && currentRound <= GameModel.TOTAL_ROUNDS) {		
			for (int i = 0; i < 5; i++) {
				if (!kept[i]) dice[i] = new Random().nextInt(6)+1;
			}
			rollCount++;
			app.updateView();
		}
	}

	/**
	 * Used by the ScorecardPanel to display prospective points for each score category.
	 * If a score is already populated, it displays the current points.
	 * This method returns a 2-D array:
	 * The first column is the point value.
	 * The second column is 1 if it's populated and 0 if it's not.
	 * 
	 * Also included in this array are several non-score elements.
	 * The ScorecardPanel also displays:
	 * 1) upper section total score
	 * 2) upper section bonus
	 * 3) count of yahtzee bonuses
	 * 4) total score
	 * 
	 * @return
	 */
	public int[][] getEvaluations() {
		int[][] evaluations = new int[17][2];
		int indexOffset = 0;
		for (int i = 0; i < 17; i++) {
			Scorecard scorecard = players[currentPlayerIndex].getScorecard();
			int scoreIndex = i - indexOffset;

			if (i == 6) {
				//upper score before bonus
				indexOffset++;
				evaluations[i][0] = scorecard.getUpperSectionPoints();
				evaluations[i][1] = 1;
			} else if (i == 7) {
				//upper bonus
				indexOffset++;
				evaluations[i][0] = scorecard.getUpperSectionBonus();
				evaluations[i][1] = 1;
			} else if (i == 15) {
				//yahtzee bonus count
				evaluations[i][0] = scorecard.getYahtzeeBonusCount();
				evaluations[i][1] = 1;
			} else if (i == 16) {
				//total score
				evaluations[i][0] = scorecard.getTotalPoints();
				evaluations[i][1] = 1;
			} 
			else if (scorecard.isPopulated(scoreIndex)) {
				evaluations[i][0] = scorecard.getPoints(scoreIndex);
				evaluations[i][1] = 1;
			} else if (rollCount > 0) {				
				evaluations[i][0] = scorecard.evaluate(dice,scoreIndex);
				evaluations[i][1] = 0;
			} else {
				evaluations[i][0] = 0;
				evaluations[i][1] = 0;
			}
		}
		return evaluations;
	}

	/**
	 * Called by the UI to set the score.
	 * If the score is already populated, nothing happens.
	 * After setting the score, the game updates the current player via passToNextPlayer().
	 * @param scoreType
	 */
	public void setScore(int scoreType) {
		if (rollCount > 0 && !players[currentPlayerIndex].getScorecard().isPopulated(scoreType)) {
			players[currentPlayerIndex].getScorecard().setScore(dice, scoreType);
			passToNextPlayer();
		}		
	}

	/**
	 * This method passes control to the next player and resets all variables used during a series of rolls.
	 * If the last player has just played, control moves back to the first player.
	 * If it's the last round, the game state is updated.
	 */
	private void passToNextPlayer() {
		resetPlayerRound();

		if (currentPlayerIndex < playerCount - 1) {
			currentPlayerIndex++;
		} else if(currentRound <= GameModel.TOTAL_ROUNDS) {
			currentPlayerIndex = 0;
			currentRound++;
		}
		if (currentRound > GameModel.TOTAL_ROUNDS){
			gameState = 3;
		}

		app.updateView();
	}

	/**
	 * This method resets the dice and roll count.
	 * This is called at the start of the round for each player.
	 */
	private void resetPlayerRound() {
		rollCount = 0;
		for(int i = 0; i < 5; i++) {
			dice[i] = 0;
			kept[i] = false;
		}
	}

	/**
	 * Called by GameApp.updateView() and passed to the UI.
	 * @return
	 */
	public int getGameState() {
		return gameState;
	}

	/**
	 * Used by DicePanel to display the roll count.
	 * @return
	 */
	public int getRollCount() {
		return rollCount;
	}

	/**
	 * This method is called by the ScoreCardPanel when a score category is clicked in the list.
	 * Then, the UI displays a description for that score.
	 * @param category
	 */
	public void setDescription(String category) {
		app.updateView(category);
	}

	/**
	 * This method is used to display winner(s) names at the end of the game.
	 */
	public String getWinnerName() {
		String name = "";
		int highScore = 0;
		for (int i = 0; i < players.length; i++) {
			if (players[i].getScorecard().getTotalPoints() > highScore) {
				highScore = players[i].getScorecard().getTotalPoints();
				name = players[i].getName();
			} else if (players[i].getScorecard().getTotalPoints() == highScore) {
				name = name + " and " + players[i].getName();
			}
		}
		return name;
	}

}
