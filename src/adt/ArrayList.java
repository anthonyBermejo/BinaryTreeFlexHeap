package adt;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Definition of the ArrayList ADT.
 * 
 * @author Anthony-Virgil Bermejo (6982166), Venelin Koulaxazov (6982425)
 */
public class ArrayList implements Iterable<Node> {

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
	 * Returns an Iterator of the ArrayList
	 */
	@Override
	public Iterator<Node> iterator() {
		Iterator<Node> it = new Iterator<Node>() {

			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < capacity();
			}

			@Override
			public Node next() {
				return array[currentIndex++];
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
			}
		};
		return it;
	}
	
	/**
	 * Returns an Iterable collection of entire ArrayList
	 * @return Iterable collection of ArrayList
	 */
	public Iterable<Node> positions() {
		return this;
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
	 * Returns the capacity of the array list
	 * 
	 * @return Capaci
	 */
	public int capacity() {
		return array.length;
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

	/**
	 * Returns the last Node within the array list.
	 * 
	 * @return last node which is not null
	 */
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
	 * @param n
	 *            Node to be found in array list
	 * @return Index of node, -1 if not found
	 */
	public int indexOf(Node n) {
		int index = -1;

		if (n != null) {
			boolean found = false;

			for (int i = 0; i <= array.length && !found; i++) {
				if (array[i] == null)
					continue;
				if (n.getKey() == array[i].getKey()
						&& n.element() == array[i].element()) {
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
	 * Returns the last index of a specific node in the array list. Returns -1
	 * if not found
	 * 
	 * @param n
	 *            Node to be found in array list
	 * @return Index of node, -1 if not found
	 */
	public int lastIndexOf(Node n) {
		int index = -1;

		if (n != null) {
			boolean found = false;

			for (int i = array.length - 1; i >= 1 && !found; i--) {
				if (array[i] == null)
					continue;
				if (n.getKey() == array[i].getKey()
						&& n.element() == array[i].element()) {
					index = i;
					found = true;
				}
			}
		}

		return index;
	}

	/**
	 * Decreases the size of the array by one, after a Node is removed.
	 */
	public void remove() {
		size--;
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
			value.setLeft(array[index].getLeft());
			value.setRight(array[index].getRight());
			array[index] = value;
		}
		return oldNode;
	}

	/**
	 * Finds either the first or last index of the first node and sets the
	 * values of the second node to the values of the first node.
	 * 
	 * @param node1
	 *            the node which will be changed
	 * @param node2
	 *            the node which values will be used for the change
	 * @param findFirstIndex
	 *            true if the first index should be used; false if the last
	 *            index should be used.
	 */
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
