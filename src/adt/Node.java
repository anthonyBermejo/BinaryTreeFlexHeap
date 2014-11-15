package adt;

import interfaces.Position;

/**
 * Class representing a Node object that holds a value and it's current Position
 * 
 * @author Anthony-Virgil Bermejo (6982166), Venelin Koulaxazov
 */
public class Node implements Position {
	private char value;
	private Node parent;
	private int key;
	private Node left;
	private Node right;
	
	/**
	 * Constructor
	 * 
	 * @param position - Current Position
	 * @param value - Value it will hold
	 */
	public Node(int key, Node parent, char value)
	{
		this.key = key;
		this.parent = parent;
		this.value = value;
	}
	
	/**
	 * Returns the value of this Node
	 * 
	 * @return value of the Position
	 */
	public char element() 
	{
		return value;
	}
	
	/**
	 * Returns the current Position of the Node within the Node List
	 * 
	 * @return current Position
	 */
	public int getKey()
	{
		return key;
	}
	
	public Node getParent()
	{
		return parent;
	}
	
	public Node getLeft()
	{
		return left;
	}
	
	public Node getRight()
	{
		return right;
	}
	
	public void setLeft(Node left)
	{
		this.left = left;
	}
	
	public void setRight(Node right)
	{
		this.right = right;
	}
}
