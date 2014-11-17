package driver;

import adt.*;

public class Driver {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		tree.setRoot(new Node(7, null, 'c'));

		System.out.println(tree.root());

		tree.setRoot(new Node(8, null, 'd'));
		System.out.println(tree.root());

		tree.addLeft(tree.root(), new Node(10, null, 'V'));
		System.out.println(tree);

		tree.addLeft(tree.root().getLeft(), new Node(11, null, 'p'));
		System.out.println(tree);

		tree.addRight(tree.root(), new Node(12, null, 'd'));
		System.out.println(tree);
	}

}
