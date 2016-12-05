package UI;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * Label formatting for total scores in PlayersListPanel
 * 
 * @author Michelle Capriles-Escobedo
 */
public class ScoreListLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	
	// padding for the labels
	Border padding = BorderFactory.createEmptyBorder(10,0,0,0);
	
    public ScoreListLabel() {
        super();
        
        this.setFont(new java.awt.Font("Copperplate", 0, 18));
        this.setForeground(Color.blue);
        this.setBorder(padding);
    }
    
    public ScoreListLabel(String label) {
        super(label);
        
        this.setFont(new java.awt.Font("Copperplate", 0, 18));
        this.setForeground(Color.blue);
        this.setBorder(padding);
    }
}
