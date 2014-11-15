package adt;

import java.util.Arrays;

public class ArrayList {

	private Node[] array;
	int size;

	/**
	 * Constructor
	 */
	public ArrayList() {
		array = new Node[10];
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
	 * Adds an element into the list at the given index
	 * 
	 * @param index
	 *            the index where the new element is to be placed
	 * @param value
	 *            Element to be set
	 */
	public void add(int index, Node value) {

		if (index < size) {
			// shift all elements
			shiftArray(index, size + 1);
		}

		array[index] = value;

		checkArraySize();
		size++;
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
		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}

		array[size] = null;
		size--;
		return removed;
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
	 * Determines if array list is empty
	 * 
	 * @return Returns true if the array list is empty, false if not
	 */
	public boolean isEmpty() {
		return (size == 0);
	}	

	/*
	 * Verifies if the size of the list is at 80% capacity
	 */
	private void checkArraySize() {
		if (((float) size / array.length) >= 0.8)
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
	private void shiftArray(int startingPosition, int endPosition) {
		Node temp1 = null;
		Node temp2 = null;

		// swap elements in the array
		for (int i = startingPosition; i < endPosition; i++) {
			temp1 = array[i];
			array[i] = temp2;
			temp2 = temp1;
		}
	}

	/*
	 * Overriden toString() method
	 */
	@Override
	public String toString() {
		return "ArrayList [array=" + Arrays.toString(array) + ", size=" + size
				+ "]";
	}
}
