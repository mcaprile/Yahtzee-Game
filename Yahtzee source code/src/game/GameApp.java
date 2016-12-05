package game;
import UI.*;

/**
 * This class contains the main method.
 * 
 * It creates an instance of the game model, the UI (game container), 
 * and it creates an instance of itself and passes it to the model 
 * so updateView() can be called back. 
 * 
 * @author Michael McCulley and Michelle Capriles-Escobedo
 */
public class GameApp {
	
	private GameModel model;
	
	// Each view gets its own object declared here.
	
	private GameContainer gameContainer;
	
	// The game is actually executed here.
	public static void main(String[] args) {
		GameApp app = new GameApp();
		app.model = new GameModel(app);	
		app.gameContainer = new GameContainer(app.model);
		app.updateView();
	}
	
	/**
	 * Will be used initially to signal the switch between the welcome screen and
	 * the game screen. Will also be used to signal the end game screen.
	 */
	public void updateView() {		
		gameContainer.draw(model.getGameState(),"");
	}
	
	/**
	 * Will update the ScoreDescriptionPanel with the category selected.
	 * 
	 * @param score description to display
	 */
	public void updateView(String description) {
		gameContainer.draw(model.getGameState(),description);
	}

}
