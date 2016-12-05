package UI;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import game.*;

/**
 * Panel that will hold the welcome screen.
 * 
 * @author Dallas Gold and Michelle Capriles-Escobedo
 */
public class WelcomeScreenUI extends JPanel {

	// Variables declaration - do not modify                     
	private javax.swing.JButton playButton;
	private javax.swing.JLabel yahtzeeWindowLabel;
	private javax.swing.JTextField playerNameField1;
	private javax.swing.JTextField playerNameField3;
	private javax.swing.JTextField playerNameField4;
	private javax.swing.JTextField playerNameField6;
	private javax.swing.JTextField playerNameField7;
	private javax.swing.JTextField playerNameField8;
	private JLabel player1;
	private JLabel player2;
	private JLabel player3;
	private JLabel player4;
	private JLabel player5;
	private JLabel player6;
	private JLabel enterNamesLabel;
	
	// End of variables declaration 
	
	private static final long serialVersionUID = 1L;
	GameModel model;

	/**
	 * Constructor creates WelcomeScreenUI Panel
	 * 
	 * @param mod game model
	 */
	public WelcomeScreenUI(GameModel mod) {
		model = mod;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	//@SuppressWarnings("unchecked") 
	public void initComponents() {

		yahtzeeWindowLabel = new javax.swing.JLabel();

		playerNameField1 = new javax.swing.JTextField(); // player 1 text field
		playerNameField3 = new javax.swing.JTextField(); // player 2 text field
		playerNameField4 = new javax.swing.JTextField(); // player 3 text field
		playerNameField6 = new javax.swing.JTextField(); // player 4 text field
		playerNameField7 = new javax.swing.JTextField(); // player 5 text field
		playerNameField8 = new javax.swing.JTextField(); // player 6 text field
		
		playButton = new javax.swing.JButton(); // button that will start the game
		
		player1 = new javax.swing.JLabel();
		player2 = new javax.swing.JLabel();
		player3 = new javax.swing.JLabel();
		player4 = new javax.swing.JLabel();
		player5 = new javax.swing.JLabel();
		player6 = new javax.swing.JLabel();
		
		enterNamesLabel = new javax.swing.JLabel();	// prompt to enter player names
		
		// Create Copperplate font to use for the game
		Font copperplate = null;
		try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     copperplate = Font.createFont(Font.TRUETYPE_FONT, GameApp.class.getResourceAsStream("/Copperplate.ttf"));
		     ge.registerFont(copperplate);
		} catch (IOException|FontFormatException e) {
		     //Handle exception
		}
		
		playButton.setVisible(true);
		playButton.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
		playButton.setText("Play Game!");

		//Add action listener to play button
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// Execute when button is pressed
				// pass player names to GameModel
				String [] playerNames = getPlayersEntered(new String[]{
						playerNameField1.getText(),playerNameField3.getText(), 
						playerNameField4.getText(),playerNameField6.getText(),
						playerNameField7.getText(),playerNameField8.getText()});

				model.setPlayers(playerNames);
			}
		});
		
		// label to prompt for entering player names
		enterNamesLabel.setFont(new java.awt.Font("Copperplate", 0, 25)); // NOI18N
		enterNamesLabel.setText("Enter the names of up to 6 players:");
		enterNamesLabel.setForeground(Color.WHITE);
		
		// labels for player names
		player1.setFont(new java.awt.Font("Copperplate", 0, 20)); // NOI18N
		player1.setText("Player 1 Name:");
		player1.setForeground(Color.WHITE);

		player2.setFont(new java.awt.Font("Copperplate", 0, 20)); // NOI18N
		player2.setText("Player 2 Name:");
		player2.setForeground(Color.WHITE);

		player3.setFont(new java.awt.Font("Copperplate", 0, 20)); // NOI18N
		player3.setText("Player 3 Name:");
		player3.setForeground(Color.WHITE);

		player4.setFont(new java.awt.Font("Copperplate", 0, 20)); // NOI18N
		player4.setText("Player 4 Name:");
		player4.setForeground(Color.WHITE);

		player5.setFont(new java.awt.Font("Copperplate", 0, 20)); // NOI18N
		player5.setText("Player 5 Name:");
		player5.setForeground(Color.WHITE);

		player6.setFont(new java.awt.Font("Copperplate", 0, 20)); // NOI18N
		player6.setText("Player 6 Name:");
		player6.setForeground(Color.WHITE);

		//set up the horizontal layout of the welcome screen components
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(114, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(player3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(player4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(player5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(player6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(playerNameField3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
																.addComponent(playerNameField4)
																.addComponent(playerNameField6))
														.addComponent(playerNameField7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(playerNameField8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(playerNameField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(yahtzeeWindowLabel)
										.addGroup(layout.createSequentialGroup()
												.addComponent(enterNamesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(20, 20, 20))))
						.addContainerGap(108, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
						.addGap(280, 280, 280)
						.addComponent(playButton)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		//set up the vertical layout of the welcome screen components
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(55, 55, 55)
						.addComponent(yahtzeeWindowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(30, 30, 30)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(enterNamesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(26, 26, 26)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(playerNameField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(playerNameField3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(playerNameField4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(player3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(playerNameField6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(player4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(playerNameField7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(player5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(20, 20, 20)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(playerNameField8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(player6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(50, 50, 50)
						.addComponent(playButton)
						.addContainerGap(64, Short.MAX_VALUE))
				);
	}


	/**
	 * Make the Welcome Screen visible
	 */
	public void draw() {
		// Set the look and feel 
		// If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		// For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(WelcomeScreenUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(WelcomeScreenUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(WelcomeScreenUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(WelcomeScreenUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		this.setVisible(true);

	}

	/**
	 * Remove visibility of the panel to go to the game screen.
	 */
	public void remove() {
		this.setVisible(false); 
	}

	/**
	 * Gets the players entered.
	 * 
	 * @param names array of player names
	 * @return player names entered
	 */
	public String[] getPlayersEntered(String[] names) {
		String[] temp = new String[6]; // will hold player names entered
		int playerCount = 0; //  keeps count of how many players were entered

		for (int i = 0; i < names.length; i++) {
			if (names[i].length() != 0){ // checks if text field is not empty
				temp[playerCount] = names[i];
				playerCount++;
			}				
		}

		 // create new array with the length of players entered
		String[] playerNames = new String[playerCount];
		java.lang.System.arraycopy(temp,0,playerNames,0,playerCount);
		return playerNames;
	}

}