package driver;

import adt.*;

public class Driver {

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		
		tree.setRoot(new Node(7, null, 'c'));
	
		System.out.println(tree.root());
		
		tree.setRoot(new Node (8, null, 'd'));
		System.out.println(tree.root());
		System.out.println(tree);
	}

}
