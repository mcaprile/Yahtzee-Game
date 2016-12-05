package UI;
/**
 * The MethodContainer interface a simple wrapper class which holds a method to be called.
 * 
 * Methods cannot be passed as parameters. So we wrap a method in this class.
 * These are passed as parameters to a MouseClickAdatper.
 * 
 * @author Michael McCulley
 *
 */
public interface MethodContainer {
	abstract void call();
}
