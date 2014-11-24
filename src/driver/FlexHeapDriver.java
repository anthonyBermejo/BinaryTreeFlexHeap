package driver;

import adt.FlexHeap;
import adt.Node;

public class FlexHeapDriver {

	public static void main(String[] args) {

		FlexHeap flexHeap = new FlexHeap();

		flexHeap.insert(new Node(19, null, 'd'));
		flexHeap.insert(new Node(14, null, 's'));
		flexHeap.insert(new Node(10, null, 't'));
		flexHeap.insert(new Node(21, null, 'm'));
		flexHeap.insert(new Node(1, null, 'A'));
		flexHeap.insert(new Node(25, null, 'n'));
		flexHeap.insert(new Node(31, null, 'b'));
		flexHeap.insert(new Node(2, null, 'A'));
		System.out.println(flexHeap);

		flexHeap.remove();
		System.out.println(flexHeap);

		flexHeap.switchMaxHeap();
		System.out.println(flexHeap);

		flexHeap.switchMinHeap();
		System.out.println(flexHeap);

		flexHeap.toggleHeap();
		System.out.println(flexHeap);
	}

}
