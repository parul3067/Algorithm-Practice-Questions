package linkedList;

import java.util.Currency;

public class RotateAfterKPlaces {

	private static LinkedList rotateAfterK(LinkedList list, int rotateAfter) {
		Node head = list.head;
		Node headAfterRotation;
		while(rotateAfter > 1) {
			head = head.next;
			rotateAfter--;
		}
		
		headAfterRotation = head.next;
		head.next = null;
		Node iterator = headAfterRotation;
		while(iterator.next != null) {
			iterator = iterator.next;
		}
		
		iterator.next = list.head;
		list.head = headAfterRotation;
		
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.print();
		
		int rotationPoint = 3;
		rotateAfterK(l1,rotationPoint).print();
	}

}
