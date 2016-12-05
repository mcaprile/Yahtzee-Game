package UI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class is an extended MouseAdapter to keep track of standard MouseAdapter events.
 * When it recognizes that a mouse has been clicked (by being both pressed and released within the bounds
 * of the associated Swing object) it calls a passed method. The method to be called is wrapped in a MethodContainer 
 * and passed in during instantiation.
 * 
 * @author Michael McCulley
 *
 */
public class MouseClickAdapter extends MouseAdapter {
	private boolean mouseDown;
	private boolean mouseOver;
	
	private MethodContainer method;
	
	public MouseClickAdapter(MethodContainer method) {
		this.method = method;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		mouseDown = true;
		mouseOver = true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if (mouseDown && mouseOver){
			mouseDown = false;
			mouseOver = false;
			method.call();
		};
	}
	
	@Override
	public void mouseEntered(MouseEvent e){
		if (mouseDown) {
			mouseOver = true;
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e){
		if (mouseDown) {
			mouseOver = false;
		}
	}
}
