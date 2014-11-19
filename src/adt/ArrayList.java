package adt;

import java.util.Arrays;

/**
 * Definition of the ArrayList ADT.
 * 
 * @author Anthony-Virgil Bermejo (6982166), Venelin Koulaxazov (6982425)
 */
public class ArrayList {

	// member variable declarations
	private Node[] array;
	int size;

	/**
	 * Default constructor
	 */
	public ArrayList() {
		array = new Node[10];
	}

	/**
	 * Adds an element into the list at the given index
	 * 
	 * @param index
	 *            the index where the new element is to be placed
	 * @param value
	 *            Element to be set
	 */
	public void add(int index, Node value) {
		size++;
		checkArraySize(index);
		if (value != null)
			array[index] = value;
	}

	/**
	 * Returns the element at the given index
	 * 
	 * @param index
	 *            the index where the element is located in the array
	 * @return Element at the given index
	 */
	public Node get(int index) {
		return array[index];
	}

	/**
	 * Returns the node within the array list that equals the given node
	 * 
	 * @param n
	 *            Node to be found
	 * @return Null, if not found, Reference to the node if found
	 */
	public Node get(Node n) {
		Node aNode = null;

		if (n != null) {
			boolean found = false;
			for (int i = 0; i < array.length && !found; i++) {
				if (array[i] == null)
					continue;
				if (n.getKey() == array[i].getKey()
						&& n.element() == array[i].element()) {
					aNode = new Node(array[i].getKey(), array[i].getParent(),
							array[i].element());
					found = true;
				}
			}
		}

		return aNode;
	}

	public Node getLast() {
		Node aNode = null;

		for (int i = array.length - 1; i >= 1; i--) {
			if (array[i] != null) {
				return array[i];
			}
		}

		return aNode;
	}

	/**
	 * Returns the index of a specific node in the array list. Returns -1 if not
	 * found
	 * 
	 * @param p
	 *            Node to be found in array list
	 * @return Index of node, -1 if not found
	 */
	public int indexOf(Node p) {
		int index = -1;

		if (p != null) {
			boolean found = false;

			for (int i = 0; i <= array.length && !found; i++) {
				if (array[i] == null)
					continue;
				if (p.getKey() == array[i].getKey()
						&& p.element() == array[i].element()) {
					index = i;
					found = true;
				}
			}
		}

		return index;
	}

	/**
	 * Returns the last index of a specific node in the array list. Returns -1
	 * if not found
	 * 
	 * @param p
	 *            Node to be found in array list
	 * @return Index of node, -1 if not found
	 */
	public int lastIndexOf(Node p) {
		int index = -1;

		if (p != null) {
			boolean found = false;

			for (int i = array.length - 1; i >= 1 && !found; i--) {
				if (array[i] == null)
					continue;
				if (p.getKey() == array[i].getKey()
						&& p.element() == array[i].element()) {
					index = i;
					found = true;
				}
			}
		}

		return index;
	}

	/**
	 * Determines if array list is empty
	 * 
	 * @return Returns true if the array list is empty, false if not
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Replaces the element at the given index with the value being sent in
	 * 
	 * @param index
	 *            the index where the element is located in the array
	 * @param value
	 *            Element to be set
	 * @return
	 */
	public Node set(int index, Node value) {
		Node oldNode = null;
		if (index >= array.length)
			throw new IndexOutOfBoundsException();

		if (value != null && array[index] != null) {
			oldNode = new Node(array[index].getKey(), array[index].getParent(),
					array[index].element());
			array[index] = value;
		}
		return oldNode;
	}

	public void set(Node node1, Node node2, boolean findFirstIndex) {
		if (findFirstIndex)
			array[indexOf(node1)] = node2;
		else 
			array[lastIndexOf(node1)] = node2;
	}

	/**
	 * Return size of the array list
	 * 
	 * @return size of array list
	 */
	public int size() {
		return size;
	}

	/**
	 * Overriden toString() method
	 */
	@Override
	public String toString() {
		return "ArrayList [array=" + Arrays.toString(array) + ", size=" + size
				+ "]";
	}

	// private methods

	/*
	 * Verifies if the size of the list is at 80% capacity
	 */
	private void checkArraySize(int index) {
		if (index >= array.length || ((float) size / array.length) >= 0.8)
			expandArray();
	}

	/*
	 * Expands the array at double its length
	 */
	private void expandArray() {
		Node[] newArray = Arrays.copyOf(array, array.length * 2);
		array = newArray;
		newArray = null;
	}
}
