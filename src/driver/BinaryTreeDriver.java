package driver;

import java.util.Iterator;

import adt.*;

public class BinaryTreeDriver {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		System.out.println(tree.isEmpty());

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

		tree.addRight(tree.root().getRight(), new Node(2, null, 'a'));
		System.out.println(tree);

		tree.addRight(tree.root().getRight().getRight(), new Node(1, null, 'b'));
		System.out.println(tree);

		try {
			tree.replace(new Node(1, null, 'b'), 'd');
		} catch (Exception e) {
		}

		System.out.println(tree);
		System.out.println(tree.hasRight(tree.root()));
		System.out.println(tree.hasLeft(tree.root()));
		System.out.println(tree.hasLeft(tree.root().getLeft().getLeft()));
		System.out.println(tree.hasRight(tree.root().getLeft().getLeft()));
		System.out.println(tree.hasRight(tree.root().getRight()));
		System.out.println(tree.hasLeft(tree.root().getRight()));

		System.out.println(tree.isRoot(tree.root()));
		System.out.println(tree.isRoot(tree.get(new Node(12, null, 'd'))));

		System.out.println(tree.isExternal(tree.root()));
		System.out.println(tree.isExternal(tree.root().getRight().getRight()
				.getRight()));

		System.out.println(tree.isInternal(tree.root()));
		System.out.println(tree.isInternal(tree.root().getRight().getRight()
				.getRight()));

		try {
			System.out.println(tree.left(tree.root()));
		} catch (Exception e) {
		}

		try {
			System.out.println(tree.right(tree.root()));
		} catch (Exception e) {
		}

		try {
			System.out.println(tree.parent(tree.root().getRight()));
		} catch (Exception e) {
		}

		tree.setRoot(new Node(1, null, 'a'));
		System.out.println(tree);
		
		Iterator<Node> it = tree.iterator();
		
		while (it.hasNext())
			System.out.println(it.next());
		
		System.out.println();
		for (Node n : tree.positions())
			System.out.println(n);
		
		System.out.println();
		for (Node n : tree.children(tree.root()))
			System.out.println(n);
		
	
		System.out.println();
		Iterable<Node> noChildren = tree.children(tree.root().getLeft().getLeft());
		for (Node n : noChildren)
			System.out.println(n);
	}

}
