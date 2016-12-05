package scores; 


//Exception if the score is already populated 
public class DuplicateScoreException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicateScoreException(String score) {
		super("The score for " + score + " has already been populated.");
	}
}
