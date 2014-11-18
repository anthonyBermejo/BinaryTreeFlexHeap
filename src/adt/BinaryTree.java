package adt;

import exceptions.NodeNotFoundException;
import adt.ArrayList;

/**
 * Definition of the BinaryTree ADT.
 * 
 * @author Anthony-Virgil Bermejo (6982166), Venelin Koulaxazov (6982425)
 */
public class BinaryTree {

	// member variable declarations
	private ArrayList list;

	/**
	 * Default constructor
	 */
	public BinaryTree() {
		list = new ArrayList();
	}

	/**
	 * Adds a left child to the specified node.
	 * 
	 * @param parent
	 *            the parent to whom a child will be added
	 * @param child
	 *            the new left child
	 */
	public void addLeft(Node parent, Node child) {
		int parentIndex = list.indexOf(parent);

		if (parentIndex != -1) {
			parent = list.get(parentIndex);
			parent.setLeft(child);
			child.setParent(parent);
			list.add(parentIndex * 2, child);
		}
	}

	/**
	 * Adds a right child to the specified node.
	 * 
	 * @param parent
	 *            the parent to whom a child will be added
	 * @param child
	 *            the new right child
	 */
	public void addRight(Node parent, Node child) {
		int parentIndex = list.indexOf(parent);

		if (parentIndex != -1) {
			parent = list.get(parentIndex);
			parent.setRight(child);
			child.setParent(parent);
			list.add(parentIndex * 2 + 1, child);
		}
	}

	/**
	 * Returns the node within the binary tree
	 * 
	 * @param n
	 *            Node to be found
	 * @return Null, if not found, Reference to the node if found
	 */
	public Node get(Node n) {
		return list.get(n);
	}

	/**
	 * Verifies whether the specified node has a left child.
	 * 
	 * @param n
	 *            the node which will be verified
	 * @return true if the node has a left child; false otherwise
	 */
	public boolean hasLeft(Node n) {
		return (n.getLeft() != null);
	}

	/**
	 * Verifies whether the specified node has a right child.
	 * 
	 * @param n
	 *            the node which will be verified
	 * @return true if the node has a right child; false otherwise
	 */
	public boolean hasRight(Node n) {
		return (n.getRight() != null);
	}

	/**
	 * Verifies whether the tree is empty.
	 * 
	 * @return true if the tree is empty; false otherwise
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Verifies whether the specified node is external.
	 * 
	 * @param n
	 *            the node which will be verified
	 * @return true if the node is external; false otherwise
	 */
	public boolean isExternal(Node n) {
		return (!hasLeft(n) && !hasRight(n));
	}

	/**
	 * Verifies whether the specified node is internal.
	 * 
	 * @param n
	 *            the node which will be verified
	 * @return true if the node is internal; false otherwise
	 */
	public boolean isInternal(Node n) {
		return (hasLeft(n) || hasRight(n));
	}

	/**
	 * Verifies if the specified node is the root of the tree.
	 * 
	 * @param n
	 *            the node which will be verified
	 * @return true if the node is the root of the tree; false otherwise
	 */
	public boolean isRoot(Node n) {
		Node root = list.get(1);

		if (root != null)
			return root.equals(n);
		return false;
	}

	/**
	 * Returns the left child of the specified node.
	 * 
	 * @param n
	 *            the node for which the left child will be returned
	 * @return left child of the node p.
	 */
	public Node left(Node n) {
		return n.getLeft();
	}

	/**
	 * Returns the parent of the specified node.
	 * 
	 * @param n
	 *            the node for which a parent will be returned
	 * @return parent of the node p
	 * @throws NodeNotFoundException
	 */
	public Node parent(Node n) throws NodeNotFoundException {
		Node aNode = null;
		Node parent = null;
		int index = list.indexOf(n);

		if (index != -1) {
			aNode = list.get(index);
			parent = aNode.getParent();
		} else
			throw new NodeNotFoundException();

		return parent;
	}
	
	/**
	 * Removes the Node at the same position as the given Node
	 * @param n Node to be removed
	 * @return Removed Node
	 */
	public Node remove(Node n)
	{
		
		
		return null;
	}

	/**
	 * Replaces the value of the specified node with a new one.
	 * 
	 * @param n
	 *            the node whose value will be changed
	 * @param c
	 *            the new value
	 * @return
	 * @throws NodeNotFoundException
	 */
	public char replace(Node n, char c) throws NodeNotFoundException {
		Node aNode = null;
		Node newNode = null;
		char oldValue = 0;
		int index = list.indexOf(n);

		if (index != -1) {
			aNode = list.get(index);
			oldValue = aNode.element();
			newNode = new Node(aNode.getKey(), aNode.getParent(), c);
			list.set(index, newNode);

			aNode = null;
			newNode = null;
		} else
			throw new NodeNotFoundException();

		return oldValue;
	}

	/**
	 * Returns the right child of the specified node.
	 * 
	 * @param n
	 *            the node for which the right child will be returned
	 * @return right child of the node p.
	 */
	public Node right(Node n) {
		return n.getRight();
	}

	/**
	 * Returns the root of the tree.
	 * 
	 * @return root of the tree
	 */
	public Node root() {
		return list.get(1);
	}

	/**
	 * Sets the root of the tree.
	 * 
	 * @param n
	 *            new root of the tree
	 */
	public void setRoot(Node n) {
		if (n != null) {
			if (list.get(1) == null)
				list.add(1, n);
			else
				list.set(1, n);
		}
	}

	/**
	 * Returns the size of the BinaryTree.
	 * 
	 * @return size of the tree
	 */
	public int size() {
		return list.size();
	}

	@Override
	public String toString() {
		return "BinaryTree [list=" + list + "]";
	}

}
