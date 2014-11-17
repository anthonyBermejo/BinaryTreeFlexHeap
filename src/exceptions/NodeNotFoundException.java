package exceptions;

/**
 * Custom exception for when a node is not found within an ArrayList
 * 
 * @author Venelin Koulaxazov (6982425)
 * @version 1.0
 */
public class NodeNotFoundException extends Exception {

	private static final long serialVersionUID = -4808624043178555346L;

	/**
	 * Constructs an NodeNotFoundException with "Node not found." as its error
	 * message.
	 */
	public NodeNotFoundException() {
		super("Node not found.");
	}

	/**
	 * Constructs a NodeNotFoundException with the specified message.
	 * 
	 * @param message
	 *            the error message.
	 */
	public NodeNotFoundException(String message) {
		super(message);
	}
}
