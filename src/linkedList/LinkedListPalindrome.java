package linkedList;

public class LinkedListPalindrome {

	private boolean isPalindrome(LinkedList list) { // check first and last elements and move the front and last last 
		boolean isPalindrome = false;               // node to reduce the list size.
		Node last;
		Node secondLast;
		Node head = list.head;
		
		while(head != null && head.next != null) {
			secondLast = head;
			last = head.next;
			while(last.next != null) {
				last = last.next;
				secondLast = secondLast.next;
			}
			if(head.data.toString().equals(last.data.toString())) {
				isPalindrome = true;
				head = head.next;
				secondLast.next = last.next;
			} else {
				isPalindrome = false;
				break;
			}
		}
		
		return isPalindrome;
	}
	
	
	private boolean optimizedPalindrome(LinkedList list) { // reverse the list from the mid point and then compare 
															// both the halves
		boolean isPalindrome = false;
		Node front = list.head;
		Node last = list.head;
		int size = 1;
		while(last.next != null) {
			last = last.next;
			size++;
		}
		int mid = size/2;
		int count = 1;
		Node midNode = list.head;
		while(count <= mid) {
			midNode = midNode.next;
			count++;
		}
		Node prev = midNode;
		Node current = midNode.next;
		Node next;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		count = 1;
		int terminate = mid;
		while(count <= terminate) {
			if(front.data != last.data) {
				isPalindrome = false;
				break;
			} else {
				isPalindrome = true;
				front = front.next;
				last = last.next;
				count++;
			}
		}
		
		return isPalindrome;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListPalindrome obj = new LinkedListPalindrome();
		LinkedList l1 = new LinkedList();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(2);
		l1.add(1);
		
		LinkedList l2 = new LinkedList(l1);
		
		l1.print();
		
		boolean isPalindrome = obj.isPalindrome(l1);
		System.out.println("Is this string palindrome ? "+isPalindrome);
		l2.print();
		System.out.println("Is this list palindrome? "+obj.optimizedPalindrome(l2));
	}

}
