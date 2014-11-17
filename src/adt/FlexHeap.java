package adt;

/**
 * Definition of the FlexHeap ADT.
 * 
 * @author Anthony-Virgil Bermejo (6982166), Venelin Koulaxazov (6982425)
 */
public class FlexHeap {

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
	 * 
	 * @return
	 */
	public int remove() {
		return 0;
	}

	/**
	 * 
	 */
	public void toggleHeap() {
		if (HeapType.MIN_HEAP == heapType)
			switchMaxHeap();
		else
			switchMinHeap();
	}

	/**
	 * 
	 */
	public void switchMinHeap() {

	}

	/**
	 * 
	 */
	public void switchMaxHeap() {

	}
}
