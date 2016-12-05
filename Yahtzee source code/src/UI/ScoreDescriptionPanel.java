package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import game.GameModel;

/**
 * Panel that displays description of score categories
 * 
 * @author Michelle Capriles-Escobedo
 */
public class ScoreDescriptionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	GameModel model;
	JLabel descriptionLabel;
	JPanel mainPanel;
	boolean end; // if it is the end of the game

	/**
	 * Constructor
	 * 
	 * @param model game model
	 */
	public ScoreDescriptionPanel(GameModel model) {
		this.model = model;
		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createLoweredBevelBorder());

		descriptionLabel = new JLabel(); // panel that will hold category descriptions
		mainPanel.add(descriptionLabel);
		mainPanel.setPreferredSize(new Dimension(270,100));
		this.add(mainPanel);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(10, 20, 15, 15)); // padding
	}

	/**
	 * Set visibility of category description
	 * 
	 * @param description
	 */
	public void draw(String description) {
		descriptionLabel.setText(getDescription(description));
		
		// if it is the end of the game want to change the formatting to display the winner
		if (end) { 
			mainPanel.setBackground(Color.GREEN);
			descriptionLabel.setFont(new Font("Copperplate", 0, 28));
		}
		this.setVisible(true);
	}

	/**
	 * Determines which text to display based on the category selected
	 * 
	 * @param category to display
	 * @return text to display
	 */
	private String getDescription(String category) {
		String description;
		switch (category) {
		case "Ones": {
			description = "<html>Add one point per number of ones<br>rolled.</html>";
			break;
		}
		case "Twos": {
			description = "<html>Add two points per number of twos<br>rolled.</html>";
			break;
		}
		case "Threes": {
			description = "<html>Add three points per number of threes<br>rolled.</html>";
			break;
		}
		case "Fours": {
			description = "<html>Add four points number of fours<br>rolled.</html>";
			break;
		}
		case "Fives": {
			description = "<html>Add five points per number of fives<br>rolled.</html>";
			break;
		}
		case "Sixes": {
			description = "<html>Add six points per number of sixes<br>rolled.</html>";
			break;
		}
		case "3 of a Kind": {
			description = "<html>Score in this box only if the dice<br>include three or more of the same <br>number. " + 
					"Add the total of the 5 dice.</html>";
			break;
		}
		case "4 of a Kind": {
			description = "<html>Score in this box only if the dice<br>include four or more of the same<br>number. " +
					"Add the total of the 5 dice.</html>";
			break;
		}
		case "Full House": {
			description = "<html>Score in this box only if the dice show<br>three of one number and two of<br>another. " +
					"Worth 25 points.</html>";
			break;
		}
		case "Small Straight": {
			description = "<html>Score in this box only if the dice show<br>a sequence of any four numbers.<br>Worth 30 points.</html>";
			break;
		}
		case "Large Straight": {
			description = "<html>Score in this box only if the dice show<br>a sequence of any five numbers.<br>Worth 40 points.";
			break;
		}
		case "Chance": {
			description = "Score the total of the five dice.";
			break;
		}
		case "Yahtzee": {
			description = "<html>Score in this box only if the dice show<br>five of the same number. Worth 50<br>points.";
			break;
		}
		case "Bonus": {
			description = "<html>If the upper sum total is equal to or<br>greater than 63, 35 points will be<br>" +
					"added to your score.</html>";
			break;
		}
		case "Yahtzee Bonus": {
			description = "<html>The number of additional Yahtzees rolled<br>after scoring a successful " +
					"initial Yahtzee.<br>Each is worth 100 bonus points.</html>";
			break;
		}
		case "Upper Sum" : {
			description = "The total sum of the upper section.";
			break;
		}
		case "End": {
			description = "<html><p style='text-align:center'>The winner is: <br>" + model.getWinnerName() + "</p></html>";
			end = true;
			break;
		}
		default: {
			description = "<html>Click on a category to read its<br>description.</html>";
			break;
		}

		}
		return description;
	}
}
