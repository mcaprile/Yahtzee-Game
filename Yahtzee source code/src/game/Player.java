package game;
import scores.*;
/**
 * This is a very simple class to hold each players' name and Scorecard object.
 * @author Mike McCulley
 * 
 */
public class Player {
	String name;
	Scorecard scorecard;
	
	public Player (String name) {
		this.name = name;
		scorecard = new Scorecard();
	}
	
	public Scorecard getScorecard() {
		return scorecard;
	}
	
	public String getName() {
		return name;
	}
}
