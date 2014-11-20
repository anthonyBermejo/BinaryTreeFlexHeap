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
			} else {
				if (!tree.isRoot(lastNode)) {
					// lastNode is a leftChild
					if (lastNode.getParent().getLeft().equals(lastNode))
						tree.addRight(lastNode.getParent(), n);
					else {
						// calculate depth of tree
						int depth = (int) Math.floor(Math.log(tree.size())
								/ Math.log(2));

						// check if current level is complete with # of nodes
						if (tree.size() < Math.pow(2, depth + 1) - 1) {
							// level is not complete
							Node node = findLeftChildParent(lastNode
									.getParent());
							Node temp = node.getParent().getRight();

							while (temp.getLeft() != null)
								temp = temp.getLeft();

							tree.addLeft(temp, n);
						} else {
							// level is complete, start at root and go left
							// until find null
							Node temp = tree.root();
							while (temp.getLeft() != null)
								temp = temp.getLeft();

							tree.addLeft(temp, n);
						}

					}
				} else
					tree.addLeft(lastNode, n);
			}
			lastNode = n;

			Node traversePosition = lastNode;

			// repair the heap based on its type
			if (heapType == HeapType.MIN_HEAP) {
				while (traversePosition.getParent() != null
						&& traversePosition.getKey() < traversePosition
								.getParent().getKey()) {
					traversePosition = swapValues(traversePosition);
				}
			} else {
				while (traversePosition.getParent() != null
						&& traversePosition.getKey() > traversePosition
								.getParent().getKey()) {
					traversePosition = swapValues(traversePosition);
				}
			}
		}
	}

	/**
	 * Removes the smallest or biggest Node of the heap and rearranges the rest
	 * of the Nodes.
	 * 
	 * @return the smallest or biggest Node which is the root of the heap
	 */
	public Node remove() {
		Node removed = null;

		if (heapType == HeapType.MIN_HEAP)
			removed = removeMin();
		else
			removed = removeMax();

		tree.remove();
		return removed;
	}

	private Node removeMax() {
		char oldRootValue = tree.root().element();
		int oldRootKey = tree.root().getKey();
		int tempKey;
		char tempValue;

		tree.root().setKey(lastNode.getKey());
		tree.root().setValue(lastNode.element());

		Node traverseNode = tree.root();

		// set lastNode to null
		Node node = tree.getLast();
		tree.set(node, null, false);

		while (traverseNode.getLeft() != null
				&& traverseNode.getRight() != null) {

			if (traverseNode.getLeft().getKey() > traverseNode.getRight()
					.getKey()) {
				if (traverseNode.getLeft().getKey() > traverseNode.getKey()) {
					tempKey = traverseNode.getKey();
					tempValue = traverseNode.element();
					traverseNode.setKey(traverseNode.getLeft().getKey());
					traverseNode.setValue(traverseNode.getLeft().element());
					traverseNode.getLeft().setKey(tempKey);
					traverseNode.getLeft().setValue(tempValue);

					traverseNode = traverseNode.getLeft();
				} else
					break;
			} else {
				if (traverseNode.getRight().getKey() > traverseNode.getKey()) {
					tempKey = traverseNode.getKey();
					tempValue = traverseNode.element();
					traverseNode.setKey(traverseNode.getRight().getKey());
					traverseNode.setValue(traverseNode.getRight().element());
					traverseNode.getRight().setKey(tempKey);
					traverseNode.getRight().setValue(tempValue);

					traverseNode = traverseNode.getRight();
				} else
					break;
			}

		}

		// set 2nd to lastNode to lastNode
		lastNode = tree.getLast();

		return new Node(oldRootKey, null, oldRootValue);
	}

	/*
	 * Removes and returns the element with the smallest or biggest key value
	 * depending on the heap status. Repairs the heap afterwards.
	 * 
	 * @return the removed element
	 */
	private Node removeMin() {
		char oldRootValue = tree.root().element();
		int oldRootKey = tree.root().getKey();
		int tempKey;
		char tempValue;

		tree.root().setKey(lastNode.getKey());
		tree.root().setValue(lastNode.element());

		Node traverseNode = tree.root();

		// set lastNode to null
		Node node = tree.getLast();
		tree.set(node, null, false);

		while (traverseNode.getLeft() != null
				&& traverseNode.getRight() != null) {

			if (traverseNode.getLeft().getKey() < traverseNode.getRight()
					.getKey()) {
				if (traverseNode.getLeft().getKey() < traverseNode.getKey()) {
					tempKey = traverseNode.getKey();
					tempValue = traverseNode.element();
					traverseNode.setKey(traverseNode.getLeft().getKey());
					traverseNode.setValue(traverseNode.getLeft().element());
					traverseNode.getLeft().setKey(tempKey);
					traverseNode.getLeft().setValue(tempValue);

					traverseNode = traverseNode.getLeft();
				} else
					break;
			} else {
				if (traverseNode.getRight().getKey() < traverseNode.getKey()) {
					tempKey = traverseNode.getKey();
					tempValue = traverseNode.element();
					traverseNode.setKey(traverseNode.getRight().getKey());
					traverseNode.setValue(traverseNode.getRight().element());
					traverseNode.getRight().setKey(tempKey);
					traverseNode.getRight().setValue(tempValue);

					traverseNode = traverseNode.getRight();
				} else
					break;
			}

		}

		// set 2nd to lastNode to lastNode
		lastNode = tree.getLast();

		return new Node(oldRootKey, null, oldRootValue);
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

	private Node findLeftChildParent(Node n) {
		if (n.equals(tree.root()))
			return n;
		if (n.equals(n.getParent().getLeft()))
			return n;
		return findLeftChildParent(n.getParent());
	}

	/*
	 * Swaps the values of the specified node with its parent.
	 */
	private Node swapValues(Node traversePosition) {
		int tempKey;
		char tempValue;

		Node temp = traversePosition.getParent();

		tempKey = temp.getKey();
		tempValue = temp.element();
		temp.setKey(traversePosition.getKey());
		temp.setValue(traversePosition.element());
		traversePosition.setKey(tempKey);
		traversePosition.setValue(tempValue);

		traversePosition = traversePosition.getParent();

		return traversePosition;
	}
}
