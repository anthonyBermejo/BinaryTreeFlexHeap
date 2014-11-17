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
	 * Returns the size of the BinaryTree.
	 * 
	 * @return size of the tree
	 */
	public int getSize() {
		return list.getSize();
	}

	public void setSize(int size) {
		list.setSize(size);
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
	 * @param p
	 *            new root of the tree
	 */
	public void setRoot(Node n) {
		if (n != null) {
			if (list.get(1) == null)
				list.setSize(getSize() + 1);
			list.set(1, n);
		}

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
	 * Returns the parent of the specified node.
	 * 
	 * @param p
	 *            the node for which a parent will be returned
	 * @return parent of the node p
	 * @throws NodeNotFoundException
	 */
	public Node parent(Node p) throws NodeNotFoundException {
		Node aNode = null;
		Node parent = null;
		int index = list.indexOf(p);

		if (index != -1) {
			aNode = list.get(index);
			parent = aNode.getParent();
		} else
			throw new NodeNotFoundException();

		return parent;
	}

	/**
	 * Verifies whether the specified node is external.
	 * 
	 * @param p
	 *            the node which will be verified
	 * @return true if the node is external; false otherwise
	 */
	public boolean isExternal(Node p) {
		return (!hasLeft(p) && !hasRight(p));
	}

	/**
	 * Verifies whether the specified node is internal.
	 * 
	 * @param p
	 *            the node which will be verified
	 * @return true if the node is internal; false otherwise
	 */
	public boolean isInternal(Node p) {
		return (hasLeft(p) || hasRight(p));
	}

	/**
	 * Verifies if the specified node is the root of the tree.
	 * 
	 * @param p
	 *            the node which will be verified
	 * @return true if the node is the root of the tree; false otherwise
	 */
	public boolean isRoot(Node p) {
		Node root = list.get(1);

		return (root != null);
	}

	public Node get(Node n) {
		return list.get(n);
	}

	/**
	 * Replaces the value of the specified node with a new one.
	 * 
	 * @param p
	 *            the node whose value will be changed
	 * @param c
	 *            the new value
	 * @return
	 * @throws NodeNotFoundException
	 */
	public char replace(Node p, char c) throws NodeNotFoundException {
		Node aNode = null;
		Node newNode = null;
		char oldValue = 0;
		int index = list.indexOf(p);

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
	 * Returns the left child of the specified node.
	 * 
	 * @param p
	 *            the node for which the left child will be returned
	 * @return left child of the node p.
	 */
	public Node left(Node p) {
		return p.getLeft();
	}

	/**
	 * Returns the right child of the specified node.
	 * 
	 * @param p
	 *            the node for which the right child will be returned
	 * @return right child of the node p.
	 */
	public Node right(Node p) {
		return p.getRight();
	}

	/**
	 * Verifies whether the specified node has a left child.
	 * 
	 * @param p
	 *            the node which will be verified
	 * @return true if the node has a left child; false otherwise
	 */
	public boolean hasLeft(Node p) {
		return (p.getLeft() != null);
	}

	/**
	 * Verifies whether the specified node has a right child.
	 * 
	 * @param p
	 *            the node which will be verified
	 * @return true if the node has a right child; false otherwise
	 */
	public boolean hasRight(Node p) {
		return (p.getRight() != null);
	}

	@Override
	public String toString() {
		return "BinaryTree [list=" + list + "]";
	}

}
