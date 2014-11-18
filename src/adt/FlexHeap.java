package adt;

/**
 * Definition of the FlexHeap ADT.
 * 
 * @author Anthony-Virgil Bermejo (6982166), Venelin Koulaxazov (6982425)
 */
public class FlexHeap {

	/*
	 * Defines the types of heap to be implemented
	 */
	private enum HeapType {
		MIN_HEAP, MAX_HEAP
	}

	// member variable declarations
	private BinaryTree tree;
	private HeapType heapType;

	/**
	 * Default constructor
	 */
	public FlexHeap() {
		tree = new BinaryTree();
		heapType = HeapType.MIN_HEAP;
	}

	/**
	 * Removes and returns the element with the smallest or biggest key value
	 * depending on the heap status. Repairs the heap afterwards.
	 * 
	 * @return the removed element
	 */
	public int remove() {
		return 0;
	}

	/**
	 * Transforms a min-heap to a max-heap if applicable.
	 */
	public void switchMaxHeap() {

	}

	/**
	 * Transforms a max-heap to a max-heap if applicable.
	 */
	public void switchMinHeap() {

	}

	/**
	 * Transforms a min- to a max-heap or vice versa.
	 */
	public void toggleHeap() {
		if (HeapType.MIN_HEAP == heapType)
			switchMaxHeap();
		else
			switchMinHeap();
	}
}
