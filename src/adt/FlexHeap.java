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
		char oldRootValue = tree.root().element();
		int oldRootKey = tree.root().getKey();

		if (tree.size() > 1) {
			tree.root().setKey(lastNode.getKey());
			tree.root().setValue(lastNode.element());

			Node traverseNode = tree.root();

			// set lastNode to null
			Node node = tree.getLast();

			// set the child of its parent to null
			if (node.getParent().getLeft().equals(node))
				node.getParent().setLeft(null);
			else
				node.getParent().setRight(null);

			// set null within array
			tree.set(node, null, false);
			tree.remove();

			while (traverseNode.getLeft() != null
					&& traverseNode.getRight() != null) {
				// heap is a min-heap therefore switching to a max-heap
				// comparing a parent's key less than its children's
				if (heapType == HeapType.MIN_HEAP) {
					// compare two children's keys and determine which one is
					// greater
					if (traverseNode.getLeft().getKey() < traverseNode
							.getRight().getKey()) {
						// determine whether the left child is less than the
						// parent; swap their values afterwards
						if (traverseNode.getLeft().getKey() < traverseNode
								.getKey()) {
							traverseNode = swapLeftWithParent(traverseNode);
						} else
							break; // no upheaping is necessary, break out of
									// loop
					} else {
						// determine whether the right child is less than the
						// parent; swap their values afterwards
						if (traverseNode.getRight().getKey() < traverseNode
								.getKey()) {
							traverseNode = swapRightWithParent(traverseNode);
						} else
							break; // no upheaping is necessary, break out of
									// loop
					}
				} else {
					// heap is a max-heap therefore switching to a min-heap
					// comparing a parent's key greater than its children's
					if (traverseNode.getLeft().getKey() > traverseNode
							.getRight().getKey()) {
						// determine whether the left child is greater than the
						// parent; swap their values afterwards
						if (traverseNode.getLeft().getKey() > traverseNode
								.getKey()) {
							traverseNode = swapLeftWithParent(traverseNode);
						} else
							break; // no upheaping is necessary, break out of
									// loop
					} else {
						// determine whether the right child is greater than the
						// parent; swap their values afterwards
						if (traverseNode.getRight().getKey() > traverseNode
								.getKey()) {
							traverseNode = swapRightWithParent(traverseNode);
						} else
							break; // no upheaping is necessary, break out of
									// loop
					}
				}
			}

			// set 2nd to lastNode to lastNode
			lastNode = tree.getLast();
		}

		removed = new Node(oldRootKey, null, oldRootValue);
		return removed;
	}

	/**
	 * Transforms a min-heap to a max-heap if applicable.
	 */
	public void switchMaxHeap() {
		if (heapType == HeapType.MIN_HEAP) {
			runDownHeap(tree.root());
			heapType = HeapType.MAX_HEAP;
		}
	}

	/**
	 * Transforms a max-heap to a min-heap if applicable.
	 */
	public void switchMinHeap() {
		if (heapType == HeapType.MAX_HEAP) {
			runDownHeap(tree.root());
			heapType = HeapType.MIN_HEAP; 
		}
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

	/*
	 * Swaps child elements depending on the heap type with the parent
	 * recursively until specified node is external.
	 */
	private void downHeap(Node node) {
		if (tree.isExternal(node))
			return;
		if (heapType == HeapType.MIN_HEAP) {
			if (node.getLeft().getKey() > node.getRight().getKey())
				downHeap(swapLeftWithParent(node));
			else
				downHeap(swapRightWithParent(node));
		} else {
			if (node.getLeft().getKey() < node.getRight().getKey())
				downHeap(swapLeftWithParent(node));
			else
				downHeap(swapRightWithParent(node));
		}
	}

	/*
	 * Finds the first parent that is a left child of the specified node; until
	 * it reaches the root
	 */
	private Node findLeftChildParent(Node n) {
		if (n.equals(tree.root()))
			return n;
		if (n.equals(n.getParent().getLeft()))
			return n;
		return findLeftChildParent(n.getParent());
	}

	/*
	 * Goes through every element within the heap and calls the downHeap method
	 * to swap values if necessary.
	 */
	private void runDownHeap(Node node) {
		if (tree.isExternal(node))
			return;
		runDownHeap(node.getLeft());
		runDownHeap(node.getRight());

		downHeap(node);
	}

	/*
	 * Swaps the left child's value and key with its parent's
	 */
	private Node swapLeftWithParent(Node traverseNode) {
		int tempKey;
		char tempValue;

		tempKey = traverseNode.getKey();
		tempValue = traverseNode.element();
		traverseNode.setKey(traverseNode.getLeft().getKey());
		traverseNode.setValue(traverseNode.getLeft().element());
		traverseNode.getLeft().setKey(tempKey);
		traverseNode.getLeft().setValue(tempValue);

		traverseNode = traverseNode.getLeft();

		return traverseNode;
	}

	/*
	 * Swaps the right child's value and key its parent's
	 */
	private Node swapRightWithParent(Node traverseNode) {
		int tempKey;
		char tempValue;

		tempKey = traverseNode.getKey();
		tempValue = traverseNode.element();
		traverseNode.setKey(traverseNode.getRight().getKey());
		traverseNode.setValue(traverseNode.getRight().element());
		traverseNode.getRight().setKey(tempKey);
		traverseNode.getRight().setValue(tempValue);

		traverseNode = traverseNode.getRight();

		return traverseNode;
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
