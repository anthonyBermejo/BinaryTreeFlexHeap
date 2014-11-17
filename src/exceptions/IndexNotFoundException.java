package exceptions;

/**
 * Custom exception for when an index is not found within an ArrayList
 * 
 * @author Venelin Koulaxazov (6982425)
 * @version 1.0
 */
public class IndexNotFoundException extends Exception {

	private static final long serialVersionUID = 2420191089813860473L;

	/**
	 * Constructs an IndexNotFoundException with "Index not found." as its error
	 * message.
	 */
	public IndexNotFoundException() {
		super("Index not found.");
	}

	/**
	 * Constructs a IndexNotFoundException with the specified message.
	 * 
	 * @param message
	 *            the error message.
	 */
	public IndexNotFoundException(String message) {
		super(message);
	}
}
