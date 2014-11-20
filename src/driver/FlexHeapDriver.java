package driver;

import adt.FlexHeap;
import adt.Node;

public class FlexHeapDriver {

	public static void main(String[] args) {

		FlexHeap flexHeap = new FlexHeap();

		flexHeap.insert(new Node(19, null, 'd'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(14, null, 's'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(10, null, 't'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(21, null, 'm'));
		System.out.println(flexHeap);
		
		flexHeap.insert(new Node(1, null, 'A'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(25, null, 'n'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(31, null, 'b'));
		System.out.println(flexHeap);

		flexHeap.insert(new Node(2, null, 'A'));
		System.out.println(flexHeap);
		
		flexHeap.remove();
		System.out.println(flexHeap);
		
		flexHeap.switchMaxHeap();
		System.out.println(flexHeap);
		
		flexHeap.switchMinHeap();
		System.out.println(flexHeap);
	}

}
