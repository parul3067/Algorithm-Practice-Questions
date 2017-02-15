package linkedList;

public class RemoveDuplicate {

	private LinkedList removeDuplicate(LinkedList list1, LinkedList list2) {
		Node iterator = list1.head;
		while(iterator.next != null) {
			if(!list2.isPresent(iterator.data)) {
				list2.add(iterator.data);
			}
			iterator = iterator.next;
		}
		if(!list2.isPresent(iterator.data)) {
			list2.add(iterator.data);
		}
		
		return list2;
	}
	
	private LinkedList removeDuplicateInPlace(LinkedList list) {
		Node current = list.head;
		
		while(current != null) {
			Node runner = current;
			while(runner.next != null) {
				if(runner.next.data.toString().equals(current.data.toString())) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicate obj = new RemoveDuplicate();
		LinkedList l1 = new LinkedList();
		/*l1.add(1.5);   //// not working for floar or double
		l1.add(2.3);
		l1.add(5.1);
		l1.add(2.3);
		l1.add(6.5);
		l1.add(2.1);
		l1.add(2.6);
		l1.add(6.5);
		*/l1.add(1);
		l1.add(1);
		l1.add(2);
		l1.add(5);
		l1.add(2);
		l1.add(6);
		l1.add(2);
		l1.add(2);
		l1.add(6);
		l1.add(7);
		l1.add(2);
		l1.print();
		
		LinkedList l2 = new LinkedList<>();
		l2 = obj.removeDuplicate(l1,l2);
		System.out.println("After deleting duplicates : out place");
		l2.print();
		l1 = obj.removeDuplicateInPlace(l1);
		System.out.println("After deleting duplicates : in place");
		l1.print();
	}

}
