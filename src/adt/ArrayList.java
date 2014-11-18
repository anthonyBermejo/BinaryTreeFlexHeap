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
		boolean found = false;
		for (int i = 0; i < array.length && !found; i++) {
			if (array[i] == null)
				continue;
			if (n.getKey() == array[i].getKey()
					&& n.element() == array[i].element()) {
				aNode = array[i];
				found = true;
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
	 * Removes the element at the specified index
	 * 
	 * @param index
	 *            the index where the element is located
	 * @return element that was removed from the array
	 */
	public Node remove(int index) {
		Node removed = array[index];

		// shift all elements to the left
		for (int i = index; i < array.length; i++) {
			if (array[i] == null)
				continue;
			array[i] = array[i + 1];
		}

		array[size] = null;
		size--;
		return removed;
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
		Node oldNode = array[index];
		array[index] = value;
		return oldNode;
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

	/*
	 * Shifts the elements in the array to the right from a starting index
	 */
//	private void shiftArray(int startingPosition, int endPosition) {
//		Node temp1 = null;
//		Node temp2 = null;
//
//		// swap elements in the array
//		for (int i = startingPosition; i < endPosition; i++) {
//			temp1 = array[i];
//			array[i] = temp2;
//			temp2 = temp1;
//		}
//	}
}
