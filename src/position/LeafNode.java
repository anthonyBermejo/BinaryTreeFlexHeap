package position;

/**
 * Class representing a LeafNode object that holds a value and it's key
 * 
 * @author Anthony-Virgil Bermejo (6982166)
 */
public class LeafNode implements Position {
	private int key;
	private char value;

	/**
	 * Constructor
	 * 
	 * @param key
	 *            Key to be set to node
	 * @param value
	 *            Value to be set to node
	 */
	public LeafNode(int key, char value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Return the element this LeafNode contains
	 * 
	 * @return element of this LeafNode
	 */
	public char element() {
		return value;
	}

	/**
	 * Return key value of this LeafNode
	 * @return Key 
	 */
	public int getKey() {
		return key;
	}

}
