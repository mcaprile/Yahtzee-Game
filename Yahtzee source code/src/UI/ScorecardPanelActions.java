package UI;

import javax.swing.ButtonGroup;

import game.GameModel;

/**
 * Another MouseClickAdapter factory class.
 * 
 * Each MouseClickAdapter method creates and returns an anonymous MouseClickAdapter
 * which in turn contains an anonymous method container, which finally holds the method to be called
 * by the MouseClickAdapter.
 * 
 * @author Michael McCulley and Michelle Capriles-Escobedo
 */
public class ScorecardPanelActions {
	private GameModel model;
	private ScorecardPanel scPanel;

	public ScorecardPanelActions(GameModel model, ScorecardPanel scPanel) {
		this.model = model;
		this.scPanel = scPanel;
	}
	
	public MouseClickAdapter setScore(ButtonGroup group){
		return new MouseClickAdapter(new MethodContainer(){
			public void call() {
				model.setScore(scPanel.getSelectedScore()); // set the score
				group.clearSelection(); // reset button selections
			}    
		});
	}
}
