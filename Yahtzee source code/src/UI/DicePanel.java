package UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import game.*;

/**
 * Panel that will contain dice rolling action.
 * 
 * @author Michael McCulley and Michelle Capriles-Escobedo
 */
public class DicePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Application objects
	GameModel model;
	ImageClickController imageClickController;

	// Images
	ImageIcon d1; // image for die 1
	ImageIcon d2; // image for die 2
	ImageIcon d3; // image for die 3
	ImageIcon d4; // image for die 4
	ImageIcon d5; // image for die 5
	ImageIcon d6; // image for die 6


	// Swing components
	JPanel mainPanel;
	JPanel rollDicePanel;
	JPanel rollDiceSubPanel;
	JPanel keptDicePanel;
	JPanel keptDiceSubPanel;
	JPanel buttonPanel;
	JLabel die0;
	JLabel die1;
	JLabel die2;
	JLabel die3;
	JLabel die4;	
	JLabel turn;
	JButton rollButton;

	/**
	 * Constructor
	 * 
	 * @param model game model
	 */
	public DicePanel(GameModel model) {
		this.model = model;
		
		// used to control actions for rolling and keeping dice
		imageClickController = new ImageClickController(model);

		// Load picture files
		loadMedia();

		// Create components
		mainPanel = new JPanel(); 
		rollDicePanel = new JPanel(); // will hold dice to roll
		rollDiceSubPanel = new JPanel(); // roll dice selected will move into here
		keptDicePanel = new JPanel(); // will hold dice to keep
		keptDiceSubPanel  = new JPanel(); // dice selected to keep will move into here
		buttonPanel = new JPanel();

		// Configure dicePanel layout	
		// ---------------------------
		// Everything is a nested panel of mainPanel
		// or a nested panel of a nested panel.
		

		turn = new JLabel("TURN:\n0/3"); // text to display the turns left
		turn.setFont(new Font("Copperplate", Font.PLAIN, 20));
		turn.setForeground(Color.WHITE);
		
		// add the turn label and different panels to a main panel
		mainPanel.add(turn);
		mainPanel.add(buttonPanel);
		mainPanel.add(rollDicePanel);	
		mainPanel.add(keptDicePanel);
		mainPanel.setOpaque(false); // set transparent background to main panel

		rollDicePanel.setBorder(BorderFactory.createLoweredBevelBorder());
		rollDicePanel.add(new JLabel("ROLL"),BorderLayout.PAGE_START);
		rollDicePanel.add(rollDiceSubPanel, BorderLayout.CENTER);

		keptDicePanel.setBorder(BorderFactory.createLoweredBevelBorder());
		keptDicePanel.add(new JLabel("KEEP"),BorderLayout.PAGE_START);
		keptDicePanel.add(keptDiceSubPanel, BorderLayout.CENTER);


		// Setup dice labels and listeners
		die0 = new JLabel();
		die0.addMouseListener(imageClickController.toggleKeepDie(0));
		rollDicePanel.add(die0);
		die1 = new JLabel();
		die1.addMouseListener(imageClickController.toggleKeepDie(1));
		rollDicePanel.add(die1);
		die2 = new JLabel();
		die2.addMouseListener(imageClickController.toggleKeepDie(2));
		rollDicePanel.add(die2);
		die3 = new JLabel();
		die3.addMouseListener(imageClickController.toggleKeepDie(3));
		rollDicePanel.add(die3);
		die4 = new JLabel();
		die4.addMouseListener(imageClickController.toggleKeepDie(4));
		rollDicePanel.add(die4);	

		rollButton = new JButton("Roll");
		rollButton.addMouseListener(imageClickController.rollDice());
		buttonPanel.add(rollButton);
		buttonPanel.setOpaque(false);
		
		this.add(mainPanel);
		this.setOpaque(false); // set transparent background to dice panel
		
		Border padding = BorderFactory.createEmptyBorder(0, 0, 15, 0);
		this.setBorder(padding); // set padding for dice panel
	}

	/**
	 * Make the dice panel visible.
	 */
	public void draw() {
		if (model.getRollCount() == 0) { // remove visibility of dice if on turn 0
			rollDiceSubPanel.setVisible(false);
			keptDiceSubPanel.setVisible(false);
		}
		else if (model.getRollCount() <= 3) { // make sure dice isn't rolled more than 3 times
			rollDiceSubPanel.setVisible(true);
			keptDiceSubPanel.setVisible(true);

			// Draw dice
			drawDice(die0,0);
			drawDice(die1,1);
			drawDice(die2,2);
			drawDice(die3,3);
			drawDice(die4,4);
		}
		turn.setText("TURN:\n" + model.getRollCount() + "/3"); // updates the turn count in the UI
		this.setVisible(true);
	}

	/**
	 * Method to make die visible based on its value
	 * 
	 * @param die the die to make visible
	 * @param dieIndex reference to specific die
	 */
	private void drawDice(JLabel die, int dieIndex){
		if(model.isKept(dieIndex)) {
			keptDiceSubPanel.add(die);
		} else {
			rollDiceSubPanel.add(die);
		}
		switch(model.getDieValue(dieIndex)) {
		case 1: 
			die.setIcon(d1);
			break;
		case 2: 
			die.setIcon(d2);
			break;
		case 3: 
			die.setIcon(d3);
			break;
		case 4: 
			die.setIcon(d4);
			break;
		case 5: 
			die.setIcon(d5);
			break;
		case 6: 
			die.setIcon(d6);
			break;
		}

	}
	
	/**
	 * Sets icon images for dice rolled.
	 */
	private void loadMedia () {
        URL url;
        url = GameApp.class.getResource("/d1.png");
        d1 = new ImageIcon(url);
        url = GameApp.class.getResource("/d2.png");
        d2 = new ImageIcon(url);
        url = GameApp.class.getResource("/d3.png");
        d3 = new ImageIcon(url);
        url = GameApp.class.getResource("/d4.png");
        d4 = new ImageIcon(url);
        url = GameApp.class.getResource("/d5.png");
        d5 = new ImageIcon(url);
        url = GameApp.class.getResource("/d6.png");
        d6 = new ImageIcon(url);
    }
	
	/**
	 * Remove visibility for DicePanel
	 */
	public void remove() {
		this.setVisible(false);
	}
}
