package UI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import game.*;

/**
 * Panel with list of player names.
 * 
 * @author Michelle Capriles-Escobedo
 */
public class PlayersListPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

		// Application objects
		GameModel model;
		
		Box playerColumnBox = Box.createVerticalBox(); // will hold player names columns
		Box scoreColumnBox = Box.createVerticalBox(); // will hold total score columns
		Box containerBox = Box.createHorizontalBox(); // will hold both columns

		// Swing components
		JPanel containerPanel;
		JPanel mainPanel;
		PlayerListLabel playerColumnLabel; // player names column title
		PlayerListLabel scoreColumnLabel; // total scores column title
		PlayerListLabel player1; // player 1 label
		PlayerListLabel player2; // player 2 label
		PlayerListLabel player3; // player 3 label
		PlayerListLabel player4; // player 4 label
		PlayerListLabel player5; // player 5 label
		PlayerListLabel player6; // player 6 label
		ScoreListLabel score1; // total score for player 1 label
		ScoreListLabel score2; // total score for player 2 label
		ScoreListLabel score3; // total score for player 3 label
		ScoreListLabel score4; // total score for player 4 label
		ScoreListLabel score5; // total score for player 5 label
		ScoreListLabel score6; // total score for player 6 label
		String[] playerNames;
		int[] playerTotals;
		
		Font boldFont = new Font("Copperplate", Font.BOLD, 20); // will be used for current player
		// will be used for the rest of the players
		Font normalFont = new Font("Copperplate", Font.PLAIN, 20); 

	/**
	 * Constructor
	 * 
	 * @param model game model
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public PlayersListPanel(GameModel model) {
		this.model = model;
		mainPanel = new JPanel();
		containerPanel = new JPanel();
		
		// used to set padding for the PlayersListPanel
		Border mainPadding = BorderFactory.createEmptyBorder(10, 0, 15, 15);
		
		containerBox.setAlignmentX(RIGHT_ALIGNMENT);
		
		// player column title formatting
		playerColumnLabel = new PlayerListLabel("Player");
        Font playerColLabelFont = playerColumnLabel.getFont();
        Map playerColLabelAttributes = playerColLabelFont.getAttributes();
        playerColLabelAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        playerColumnLabel.setFont(playerColLabelFont.deriveFont(playerColLabelAttributes));
        playerColumnBox.add(playerColumnLabel);
        playerColumnBox.setAlignmentX(LEFT_ALIGNMENT);
        
        // score column title formatting
		scoreColumnLabel = new PlayerListLabel("Score");
		scoreColumnLabel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        Font scoreColLabelFont = scoreColumnLabel.getFont();
        Map scoreColLabelAttributes = scoreColLabelFont.getAttributes();
        scoreColLabelAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        scoreColumnLabel.setFont(scoreColLabelFont.deriveFont(playerColLabelAttributes));
        scoreColumnBox.add(scoreColumnLabel);
        scoreColumnBox.setAlignmentX(RIGHT_ALIGNMENT);
		
        // initialize player name and total score labels
        player1 = new PlayerListLabel();
        playerColumnBox.add(player1);
        score1 = new ScoreListLabel();
        scoreColumnBox.add(score1);
        
        player2 = new PlayerListLabel();
        playerColumnBox.add(player2);
        score2 = new ScoreListLabel();
        scoreColumnBox.add(score2);
        
        player3 = new PlayerListLabel();
        playerColumnBox.add(player3);
        score3 = new ScoreListLabel();
        scoreColumnBox.add(score3);
        
        player4 = new PlayerListLabel();
        playerColumnBox.add(player4);
        score4 = new ScoreListLabel();
        scoreColumnBox.add(score4);
        
        player5 = new PlayerListLabel();
        playerColumnBox.add(player5);
        score5 = new ScoreListLabel();
        scoreColumnBox.add(score5);
        
        player6 = new PlayerListLabel();
        playerColumnBox.add(player6);
        score6 = new ScoreListLabel();
        scoreColumnBox.add(score6);
        
        // add player player column and total score column to the container box
        containerBox.add(playerColumnBox);
        containerBox.add(scoreColumnBox);
        
        // main panel formatting
		mainPanel.add(containerBox); 
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBorder(mainPadding);
		mainPanel.setOpaque(false);
		
		containerPanel.add(mainPanel);
		containerPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		containerPanel.setPreferredSize(new Dimension(270,270));
		
		this.add(containerPanel);
		this.setOpaque(false);
	}
	
	/**
	 * Set the names of the players in the PlayersListPanel
	 */
	public void setNames() {
		playerNames = model.getPlayerNames();
		playerTotals = model.getScoreTotals();
		int currentPlayer = model.getCurrentPlayerIndex();
		
		JLabel[] playerLabels = new JLabel[] {player1,player2,player3,player4,player5,player6};
		JLabel[] scoreLabels = new JLabel[] {score1,score2,score3,score4,score5,score6};
		
		for (int i = 0; i < playerNames.length; i++) { // go through player names
			playerLabels[i].setText(playerNames[i]); // set player label with player name
			scoreLabels[i].setText(String.valueOf(playerTotals[i])); // assign corresponding total score
			
			if (i == currentPlayer) { // formatting for current player
				playerLabels[i].setFont(boldFont);
				scoreLabels[i].setFont(boldFont);
				scoreLabels[i].setForeground(Color.red);
			}
			else {
				playerLabels[i].setFont(normalFont);
				scoreLabels[i].setFont(normalFont);
				scoreLabels[i].setForeground(Color.blue);
			}
		}
	}
	
	/**
	 * Set visibility for PlayersListPanel
	 */
	public void draw() {
		this.setVisible(true);
	}
}
