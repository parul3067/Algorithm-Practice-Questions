package linkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/* class ListNode {
      int data;
      ListNode next;
      ListNode() {
          
      }
      ListNode(int x) { 
          data = x;
          next = null;
      }
  }
  */
public class Sum {
    Node head = null;
    Node tail = null;
    
    private void addNode(int sum) {
        Node newNode = new Node(sum);
        Node iterator;
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public Node<Integer> addTwoNumbers(Node<Integer> l1, Node<Integer> l2) {
        Node head1 = l1;
		Node head2 = l2;
		int carry = 0;
		while(head1 != null && head2 != null) {
			int sum = 0;
			sum = (int)head1.data + (int)head2.data + carry;
			carry = sum/10;
			sum = sum%10;
			addNode(sum);
			head1 = head1.next;
			head2 = head2.next;
		}
		
		if(head1 != null) {
			while(head1 != null) {
				int sum = 0;
				sum = (int)head1.data + carry;
				carry = sum/10;
				sum = sum%10;
				addNode(sum);
				head1 = head1.next;
			}
		}
		
		if(head2 != null) {
			while(head2 != null) {
				int sum = 0;
				sum = (int)head2.data + carry;
				carry = sum/10;
				sum = sum%10;
				addNode(sum);
				head2 = head2.next;
			}
		}
		
		
		if(carry > 0) {
			addNode(carry);
		}
		
		return head;
    }
    
    public static void main(String args[]) {
    	LinkedList l1 = new LinkedList();
		l1.add(2);
		l1.add(4);
		l1.add(3);
		LinkedList l2 = new LinkedList();
		l2.add(5);
		l2.add(6);
		l2.add(4);
		LinkedList l3 = new LinkedList();
		Sum obj = new Sum();
		l3.head = obj.addTwoNumbers(l1.head, l2.head);
		
		l3.print();
    }
}