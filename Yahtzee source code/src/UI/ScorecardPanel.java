package UI;
import game.GameModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;
import scores.Scorecard;

/**
 * Panel that displays the scorecard for the current player.
 * 
 * @author Dallas Gold, Michelle Capriles-Escobedo, and Michael McCulley
 */
public class ScorecardPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	GameModel model;
	ImageClickController imageClickController;

	// Variables declaration
	//visual components declared
	private final javax.swing.JButton setScoreButton;
	@SuppressWarnings("rawtypes")
	private final javax.swing.JList categoryList;
	private final javax.swing.JPanel mainPanel;
	private final javax.swing.JScrollPane categoryPane;
	private final javax.swing.JScrollPane scorePane;

	private int scoreSelected;

	//radio button names 
	static String oneString = "0";
	static String twoString = "1";
	static String threeString = "2";
	static String fourString = "3";
	static String fiveString = "4";
	static String sixString = "5";
	static String threeKindString = "6";
	static String fourKindString = "7";
	static String fullHouseString = "8";
	static String ssString = "9";
	static String lsString = "10";
	static String yahtzeeString = "11";
	static String chanceString = "12";

	//score category label declarations
	private JLabel onesLabel;
	private JLabel twosLabel;
	private JLabel threesLabel;
	private JLabel foursLabel;
	private JLabel fivesLabel;
	private JLabel sixesLabel;
	private JLabel upperBonusLabel;
	private JLabel upperSumLabel;
	private JLabel threeKindLabel;
	private JLabel fourKindLabel;
	private JLabel ssLabel;
	private JLabel lsLabel;
	private JLabel fullHouseLabel;
	private JLabel yahtzeeLabel;
	private JLabel chanceLabel;
	private JLabel yahtzeeBonusLabel;
	private JLabel totalLabel;
	private JLabel scoreColumnLabel;
	private JLabel[][] scoreLabels;

	//radio buttons work together as a group - allows only one to be selected
	ButtonGroup group;

	private ScorecardPanelActions actions;

	//used a box to store scores
	Box scoreColumnBox = Box.createVerticalBox();

	/**
	 * Constructor - sets up new ScorecardPanel
	 * 
	 * @param model game model
	 */
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public ScorecardPanel(GameModel model) {

		//create the various UI components
		this.model = model;
		actions = new ScorecardPanelActions(model,this);

		mainPanel = new javax.swing.JPanel();
		categoryPane = new javax.swing.JScrollPane();
		categoryList = new javax.swing.JList();
		setScoreButton = new javax.swing.JButton();
		scorePane = new javax.swing.JScrollPane();
		new javax.swing.JTable();

		// scoring column labels
		scoreLabels = new JLabel[][] {
			{onesLabel = new JLabel()},
			{twosLabel = new JLabel()},
			{threesLabel = new JLabel()},
			{foursLabel = new  JLabel()},
			{fivesLabel = new JLabel()},
			{sixesLabel = new JLabel()},
			{upperSumLabel = new JLabel()},
			{upperBonusLabel = new JLabel()},
			{threeKindLabel = new JLabel()},
			{fourKindLabel = new JLabel()},
			{fullHouseLabel = new JLabel()},
			{ssLabel = new JLabel()},
			{lsLabel = new JLabel()},
			{yahtzeeLabel = new JLabel()},
			{chanceLabel = new JLabel()},
			{yahtzeeBonusLabel = new JLabel()},
			{totalLabel = new JLabel()}
		};

		//add the the appropriate rows to the scores box column
		Border scoreColumnPadding = BorderFactory.createEmptyBorder(0, 10, 0, 10);
		scoreColumnLabel = new JLabel("Score");
		scoreColumnLabel.setFont(new Font("Copperplate", 0, 22));

		scoreColumnBox.add(scoreColumnLabel);
		scoreColumnBox.add(onesLabel);
		scoreColumnBox.add(twosLabel);
		scoreColumnBox.add(threesLabel);
		scoreColumnBox.add(foursLabel);
		scoreColumnBox.add(fivesLabel);
		scoreColumnBox.add(sixesLabel);
		scoreColumnBox.add(upperSumLabel);
		scoreColumnBox.add(upperBonusLabel);
		scoreColumnBox.add(threeKindLabel);
		scoreColumnBox.add(fourKindLabel);
		scoreColumnBox.add(fullHouseLabel);
		scoreColumnBox.add(ssLabel);
		scoreColumnBox.add(lsLabel);
		scoreColumnBox.add(yahtzeeLabel);
		scoreColumnBox.add(chanceLabel);
		scoreColumnBox.add(yahtzeeBonusLabel);
		scoreColumnBox.add(totalLabel);

		scoreColumnBox.setBorder(scoreColumnPadding);

		//populate score column
		for (int i = 0; i < 17; i++) {
			scoreLabels[i][0].setFont(new Font("Copperplate", 0, 20));
		}

		mainPanel.add(categoryPane);
		mainPanel.add(scorePane);
		mainPanel.add(categoryList);
		mainPanel.add(setScoreButton);
		mainPanel.setOpaque(false);

		//Create the score radio buttons.
		JRadioButton oneButton = new JRadioButton(oneString);
		oneButton.addMouseListener(radioButtonClick(Scorecard.ONES));
		oneButton.setOpaque(false);
		oneButton.setFocusable(false);

		JRadioButton twoButton = new JRadioButton(twoString);
		twoButton.addMouseListener(radioButtonClick(Scorecard.TWOS));
		twoButton.setOpaque(false);
		twoButton.setFocusable(false);

		JRadioButton threeButton = new JRadioButton(threeString);
		threeButton.addMouseListener(radioButtonClick(Scorecard.THREES));
		threeButton.setOpaque(false);
		threeButton.setFocusable(false);

		JRadioButton fourButton = new JRadioButton(fourString);
		fourButton.addMouseListener(radioButtonClick(Scorecard.FOURS));
		fourButton.setOpaque(false);
		fourButton.setFocusable(false);

		JRadioButton fiveButton = new JRadioButton(fiveString);
		fiveButton.addMouseListener(radioButtonClick(Scorecard.FIVES));
		fiveButton.setOpaque(false);
		fiveButton.setFocusable(false);

		JRadioButton sixButton = new JRadioButton(sixString);
		sixButton.addMouseListener(radioButtonClick(Scorecard.SIXES));
		sixButton.setOpaque(false);
		sixButton.setFocusable(false);

		JRadioButton threeKindButton = new JRadioButton(threeKindString);
		threeKindButton.addMouseListener(radioButtonClick(Scorecard.THREE_OF_A_KIND));
		threeKindButton.setOpaque(false);
		threeKindButton.setFocusable(false);

		JRadioButton fourKindButton = new JRadioButton(fourKindString);
		fourKindButton.addMouseListener(radioButtonClick(Scorecard.FOUR_OF_A_KIND));
		fourKindButton.setOpaque(false);
		fourKindButton.setFocusable(false);

		JRadioButton fullHouseButton = new JRadioButton(fullHouseString);
		fullHouseButton.addMouseListener(radioButtonClick(Scorecard.FULL_HOUSE));
		fullHouseButton.setOpaque(false);
		fullHouseButton.setFocusable(false);

		JRadioButton ssButton = new JRadioButton(ssString);
		ssButton.addMouseListener(radioButtonClick(Scorecard.SMALL_STRAIGHT));
		ssButton.setOpaque(false);
		ssButton.setFocusable(false);

		JRadioButton lsButton = new JRadioButton(lsString);
		lsButton.addMouseListener(radioButtonClick(Scorecard.LARGE_STRAIGHT));
		lsButton.setOpaque(false);
		lsButton.setFocusable(false);

		JRadioButton yahtzeeButton = new JRadioButton(yahtzeeString);
		yahtzeeButton.addMouseListener(radioButtonClick(Scorecard.YAHTZEE));
		yahtzeeButton.setOpaque(false);
		yahtzeeButton.setFocusable(false);

		JRadioButton chanceButton = new JRadioButton(chanceString);
		chanceButton.addMouseListener(radioButtonClick(Scorecard.CHANCE));
		chanceButton.setOpaque(false);
		chanceButton.setFocusable(false);

		//Group the radio buttons so they operate cohesively
		group = new ButtonGroup();
		group.add(oneButton);
		group.add(twoButton);
		group.add(threeButton);
		group.add(fourButton);
		group.add(fiveButton);
		group.add(sixButton);
		group.add(threeKindButton);
		group.add(fourKindButton);
		group.add(fullHouseButton);
		group.add(ssButton);
		group.add(lsButton);
		group.add(yahtzeeButton);
		group.add(chanceButton);

		//Put the radio buttons in a column in a panel.
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(oneButton);
		radioPanel.add(twoButton);
		radioPanel.add(threeButton);
		radioPanel.add(fourButton);
		radioPanel.add(fiveButton);
		radioPanel.add(sixButton);
		radioPanel.add(threeKindButton);
		radioPanel.add(fourKindButton);
		radioPanel.add(fullHouseButton);
		radioPanel.add(ssButton);
		radioPanel.add(lsButton);
		radioPanel.add(yahtzeeButton);
		radioPanel.add(chanceButton);

		//spacing and visuals for radio button panel
		add(radioPanel, BorderLayout.LINE_START);
		radioPanel.setBounds(150, 50, 0, 0);
		mainPanel.add(radioPanel);
		radioPanel.setOpaque(false); 

		//creates the score category names 
		categoryList.setAutoscrolls(false);
		categoryList.setFixedCellHeight(24);
		categoryList.setFont(new java.awt.Font("Copperplate", 1, 20)); // NOI18N
		categoryList.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { "CATEGORY", "Ones", "Twos", "Threes", "Fours", 
					"Fives", "Sixes", "Upper Sum", "Bonus", "3 of a Kind", 
					"4 of a Kind", "Full House", "Small Straight", "Large Straight", 
					"Yahtzee", "Chance", "Yahtzee Bonus", 
			"TOTAL" };
			public int getSize() { return strings.length; }
			public Object getElementAt(int i) { return strings[i]; }
		});

		categoryPane.setViewportView(categoryList);
		scorePane.setViewportView(scoreColumnBox);


		setScoreButton.setText("Score");

		// reacts to selection of categories to display their description in the
		// ScoreDescriptionPanel
		MouseAdapter mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 1) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						Object o = theList.getModel().getElementAt(index);
						setScoreDescription(o.toString());
					}
				}
			}
		};

		//looks for clicks to category and scoring button
		categoryList.addMouseListener(mouseListener);
		setScoreButton.addMouseListener(actions.setScore(group));

		//controls the spacing and size of the horizontal components
		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout.setHorizontalGroup(
				mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(mainPanelLayout.createSequentialGroup()
						.addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(oneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(twoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(threeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(fourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(fiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(sixButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(threeKindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(fourKindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(fullHouseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(ssButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(lsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(yahtzeeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(chanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(categoryPane, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(scorePane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(28, 28, 28))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(setScoreButton)	
						.addGap(127, 127, 127))
				);
		
		//controls the spacing and size of the vertical components
		mainPanelLayout.setVerticalGroup(
				mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(mainPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(mainPanelLayout.createSequentialGroup()			
												.addComponent(oneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,6,6)
												.addComponent(twoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,6,6)
												.addComponent(threeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,6,6)
												.addComponent(fourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,6,6)
												.addComponent(fiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,6,6)
												.addComponent(sixButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(54, 54, 54)
												.addComponent(threeKindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,6,6)
												.addComponent(fourKindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,6,6)
												.addComponent(fullHouseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,6,6)
												.addComponent(ssButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,6,6)
												.addComponent(lsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,6,6)
												.addComponent(yahtzeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,6,6)
												.addComponent(chanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(52, 52, 52))

										.addComponent(scorePane, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(categoryPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(10, 10, 10)
						.addComponent(setScoreButton)
						));

		// controls the horizontal layout of the components
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(820, Short.MAX_VALUE)
						.addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		
		// controls the vertical layout of the components
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 375, Short.MAX_VALUE))
				);
	}
	
	/**
	 * Gets the container panel
	 * 
	 * @return mainPanel
	 */
	public JPanel getMainPanel() {
		return this.mainPanel;
	}
	
	/**
	 * Display the ScorecardPanel
	 */
	public void draw() {
		getScores(); // display the score for the current player
		this.setVisible(true);
	}

	/**
	 * Sets the category description to display in ScoreDescriptionPanel
	 * @param category to set description for
	 */
	public void setScoreDescription(String category) {
		model.setDescription(category);
	}
	
	/**
	 * Sets the formatting for the score labels
	 * 
	 * @return formatted score labels
	 */
	public JLabel[][] getScores() {
		int[][] intScores = model.getEvaluations();

		for (int i = 0; i < 17; i++) {
			// set text for category label
			scoreLabels[i][0].setText("<html><p style='line-height:24px; padding: 1px;'>" + 
					String.valueOf(intScores[i][0]) + "</p></html>");

			if (intScores[i][1] == 1) { // 1 indicates the score is set and should thus be black
				scoreLabels[i][0].setForeground(Color.BLACK);
			}
			else if (intScores[i][0] == 0) { // 0 indicates the score slot is open and should thus be red
				scoreLabels[i][0].setForeground(Color.RED);
			}
		}
		return scoreLabels;
	}
	
	/**
	 * Sets the score the player chose for the round
	 * 
	 * @param score the player chose
	 */
	public void setSelectedScore(int score) {
		this.scoreSelected = score;
	}
	
	/**
	 * Retrieves player's selected score
	 * 
	 * @return score selected by the player
	 */
	public int getSelectedScore() {
		return this.scoreSelected;
	}
	
	/**
	 * Method to return a MouseClickAdapter for each radio button to set the 
	 * selected score type.
	 * @param scoreType
	 * @return
	 */
	private MouseClickAdapter radioButtonClick(int scoreType){
		return new MouseClickAdapter(new MethodContainer(){
			@Override
			public void call() {
				setSelectedScore(scoreType);
			}    
		});
	}

}

