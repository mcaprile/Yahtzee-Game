package UI;
import game.*;

/**
 * This class a factory class which creates MouseClickAdapter objects which can be added as a listener
 * to the Swing components such as a JLabel (which don't have basic usage of an ActionListener).
 * 
 * Each MouseClickAdapter method creates and returns an anonymous MouseClickAdapter
 * which in turn contains an anonymous method container, which finally holds the method to be called
 * by the MouseClickAdapter.
 *  
 * @author Michael McCulley
 *
 */
public class ImageClickController {
	//Since the game model is used by the methods, it is passed into the constructor and a reference is held.
	private GameModel model;

	/**
	 * Set the reference to the game model.
	 * @param model
	 */
	public ImageClickController(GameModel model) {
		this.model = model;
	}

	/**
	 * This MouseClickAdapter calls a method to keep/release a die to be rolled.
	 * 
	 * @param die
	 * @return
	 */
	public MouseClickAdapter toggleKeepDie(int die){
		return new MouseClickAdapter(new MethodContainer(){
			@Override
			public void call() {
				model.keepDie(die, !model.isKept(die));
			}    
		});
	}
	
	/**
	 * This MouseClickAdapter calls a method to roll the dice.
	 * @return
	 */
	public MouseClickAdapter rollDice () {

		return new MouseClickAdapter(new MethodContainer() {
			@Override
			public void call() {
				model.rollDice();
			}    
		});
	}
}

