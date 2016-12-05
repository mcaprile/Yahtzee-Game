package UI;
import javax.swing.*;
import javax.swing.border.Border;
import UI.WelcomeScreenUI;
import java.awt.*;
import game.*;

/**
 * Will contain and control the display of the game window.
 * 
 * @author Michelle Capriles-Escobedo
 */
public class GameContainer extends JFrame {

	private static final long serialVersionUID = 1L;
	GameModel model;
	DicePanel dPanel;
	ScorecardPanel scPanel;
	PlayersListPanel plPanel;
	ScoreDescriptionPanel sdPanel;
	JPanel leftPanel; // will hold the PlayersListPanel and the ScoreDescriptionPanel
	
	// will be used to line up PlayersList Panel and ScoreDescriptionPanel
	// on top of each other
	Box leftBox = Box.createVerticalBox(); 
	JLabel contentPane; // will be used to add background image
	WelcomeScreenUI welcomeScreen;

	/**
	 * Constructor - create game window
	 * 
	 * @param model to use for controlling the display
	 */
	public GameContainer(GameModel model) {

		// Initialize JFrame properties
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 700);
		this.setTitle("Yahtzee Game");

		dPanel = new DicePanel(model);
		scPanel = new ScorecardPanel(model);
		plPanel = new PlayersListPanel(model);
		sdPanel = new ScoreDescriptionPanel(model);

		plPanel.setAlignmentY(TOP_ALIGNMENT);
		sdPanel.setAlignmentY(TOP_ALIGNMENT);
		leftBox.add(plPanel);
		leftBox.add(sdPanel);

		welcomeScreen = new WelcomeScreenUI(model);
		welcomeScreen.setOpaque(false); // set welcome screen background to be transparent

		java.net.URL url = GameApp.class.getResource("/Yahtzee bg.png");
		ImageIcon img = new ImageIcon(url);

		contentPane = new JLabel();
		contentPane.setIcon(img); // set background image
		contentPane.setLayout(new BorderLayout()); // add padding to the window
		this.setContentPane(contentPane);

	}
	
	/**
	 * Used to control which view of the game to display.
	 * 
	 * @param display indicator of which display to use
	 * @param description score description to display in ScoreDescriptionPanel
	 */
	public void draw(int display,String description) {
		
		if (display == 1) { // initial game state is Welcome Screen
			this.add(welcomeScreen,BorderLayout.NORTH);
		}
		else if (display == 2) { // commence view of the game
			welcomeScreen.remove(); // remove visibility of Welcome Screen
			
			plPanel.setNames(); // pass player names to PlayersListPanel
			
			this.add(dPanel,BorderLayout.SOUTH); // play DicePanel at the bottom
			this.add(scPanel.getMainPanel(),BorderLayout.EAST); // place ScorecardPanel on the right
			
			// padding for PlayersListPanel
			Border padding = BorderFactory.createEmptyBorder(80, 5, 10, 0);
			plPanel.setBorder(padding);
			
			// place PlayersListPanel and ScoreDescriptionPanel on the left
			this.add(leftBox,BorderLayout.WEST);
			
			// set visiblity of all the game panels
			dPanel.draw();
			scPanel.draw();
			plPanel.draw();
			sdPanel.draw(description);
		}
		else if (display == 3) { // end game state
			scPanel.draw();
			sdPanel.draw("End");
		}
		
		this.setVisible(true);
	}
}

