package driver;

import adt.*;

public class Driver {

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		
		tree.setRoot(new Node(7, null, 'c'));
		tree.addLeft(tree.root(), new Node(1, tree.root(), 'f'));
		tree.addRight(new Node());///
		
	}

}
