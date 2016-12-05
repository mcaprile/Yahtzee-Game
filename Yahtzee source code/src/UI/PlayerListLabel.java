package UI;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * Label formatting for player names in PlayersListPanel
 * 
 * @author Michelle Capriles-Escobedo
 */
public class PlayerListLabel extends JLabel {
	
	private static final long serialVersionUID = 1L;
	
	// padding for the labels
	Border padding = BorderFactory.createEmptyBorder(10,0,0,50);

    public PlayerListLabel() {
        super();
        
        this.setFont(new java.awt.Font("Copperplate", 0, 18));
        this.setBorder(padding);
    }
    
    public PlayerListLabel(String label) {
        super(label);
        
        this.setFont(new java.awt.Font("Copperplate", 0, 18));
        this.setBorder(padding);
    }
}