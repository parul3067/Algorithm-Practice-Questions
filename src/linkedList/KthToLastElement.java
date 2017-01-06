package linkedList;

import java.util.Scanner;

public class KthToLastElement {

	private <T>T kthElementFromEnd(LinkedList list, int index) {
		Node current = list.head;
		Node runner = current;
		int count = 0;
		if(index == 0) {
			index = 1;
		}
		while(count < index && runner != null) {
			count++;
			runner = runner.next;
		}
		while(runner != null) {
			runner = runner.next;
			current = current.next;
		}
		
		return (T)current.data;
	}
	
	//case when you input index = 20 should return the first value of the linked list. Need to find this case????
	
	private int kthElementFromEndRecursion(Node head, int index) {
		if(index == 0) {
			index = 1;
		}
		if(head == null) {
			return 0;
		}
		
		int k = kthElementFromEndRecursion(head.next, index) + 1;
		if(k == index) {
			System.out.println(head.data);
		}
		
		return k;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		KthToLastElement obj = new KthToLastElement();
		LinkedList l1 = new LinkedList();
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
		
		System.out.println("Enter the index you want to find from end");
		int index = sc.nextInt();
		System.out.println("using two pointers");
		System.out.print(obj.kthElementFromEnd(l1, index));
		System.out.println();
		System.out.println("using recursion");
		obj.kthElementFromEndRecursion(l1.head, index);
	}

}
