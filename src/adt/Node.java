package adt;

import interfaces.Position;

/**
 * Class representing a Node object that holds a value and it's current Position
 * 
 * @author Anthony-Virgil Bermejo (6982166), Venelin Koulaxazov (6982425)
 */
public class Node implements Position {

	// member variable declarations
	private char value;
	private Node parent;
	private int key;
	private Node left;
	private Node right;

	/**
	 * Constructor setting specified values.
	 * 
	 * @param key
	 * @param parent
	 * @param value
	 */
	public Node(int key, Node parent, char value) {
		this.key = key;
		this.parent = parent;
		this.value = value;
	}

	/**
	 * Returns the value of this Node
	 * 
	 * @return value of the Position
	 */
	public char element() {
		return value;
	}

	/**
	 * Returns the current Position of the Node within the Node List
	 * 
	 * @return current Position
	 */
	public int getKey() {
		return key;
	}

	/**
	 * Returns the parent of the current Node.
	 * 
	 * @return parent of the Node
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * Returns the left child of the current Node.
	 * 
	 * @return left child of the Node
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * Returns the right child of the current Node.
	 * 
	 * @return right child of the Node
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * Sets the parent of the current Node.
	 * 
	 * @param parent
	 *            new parent of the node
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}

	/**
	 * Sets the left child of the current Node.
	 * 
	 * @param left
	 *            the new left child of the Node
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * Sets the right child of the current Node.
	 * 
	 * @param right
	 *            new right child of the Node
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * Overriden toString() method
	 */
	@Override
	public String toString() {
		return "Node [value=" + value + ", parent=" + parent + ", key=" + key
				+ ", left=" + left + ", right=" + right + "]";
	}
}
