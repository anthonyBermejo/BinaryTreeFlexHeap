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
	private Node lastNode;

	/**
	 * Default constructor
	 */
	public FlexHeap() {
		tree = new BinaryTree();
		heapType = HeapType.MIN_HEAP;
	}

	// public methods

	/**
	 * Inserts a Node in the heap and sorts the heap accordingly.
	 * 
	 * @param n
	 *            the new Node to be inserted
	 */
	public void insert(Node n) {
		if (n != null) {
			if (tree.size() == 0) {
				tree.setRoot(n);
				lastNode = tree.root();
			} else {
				if (!tree.isRoot(lastNode)) {
					if (lastNode.getParent().getLeft().equals(lastNode))
						tree.addRight(lastNode.getParent(), n);
					else {
						Node node = findLeftChild(lastNode);
						Node temp = node;
						if (temp.getLeft() != null) {
							while (temp.getLeft() != null)
								temp = temp.getLeft();
							tree.addLeft(temp, n);
						} else {
							tree.addRight(temp.getParent(), n);
						}

					}
				} else
					tree.addLeft(lastNode, n);
				lastNode = n; 
			}
		}
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

	/**
	 * Overriden toString() method.
	 */
	@Override
	public String toString() {
		return "FlexHeap [tree=" + tree + ", heapType=" + heapType
				+ ", lastNode=" + lastNode + "]";
	}

	// private methods

	private Node findLeftChild(Node n) {
		if (n.getParent().equals(tree.root()))
			return n.getParent();
		if (n.getParent().getParent().getRight()
				.equals(n.getParent().getLeft()))
			return n;
		return findLeftChild(n.getParent());
	}
}
