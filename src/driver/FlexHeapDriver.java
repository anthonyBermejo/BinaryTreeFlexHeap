package driver;

import adt.FlexHeap;
import adt.Node;

public class FlexHeapDriver {

	public static void main(String[] args) {

		FlexHeap flexHeap = new FlexHeap();

		flexHeap.insert(new Node(12, null, 'd'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(14, null, 's'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(10, null, 't'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(14, null, 'D'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(14, null, 'x'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(21, null, 'm'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(25, null, 'n'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(27, null, 'o'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(28, null, 'c'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(30, null, 'a'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(31, null, 'b'));
		System.out.println(flexHeap);
	}

}
