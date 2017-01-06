package linkedList;


public class SumOfTwoLinkedListMethod2 {
	
	Node head;
	private void addNode(int sum) {
		Node newNode = new Node(sum);
		Node iterator;
        if(head == null) {
            head = newNode;
        } else {
            iterator = head;
            while(iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
        }
    }
	
	public Node addTwoNumbers(Node l1, Node l2) {
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
	
	private LinkedList sumOfTwoList(LinkedList l1, LinkedList l2) {
		LinkedList l3 = new LinkedList();
		
		l3.head = addTwoNumbers(l1.head,l2.head);
		return l3;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumOfTwoLinkedListMethod2 obj = new SumOfTwoLinkedListMethod2();
		LinkedList l1 = new LinkedList();
		l1.add(7);
		l1.add(1);
		l1.add(9);
		LinkedList l2 = new LinkedList();
		l2.add(5);
		l2.add(9);
		l2.add(2);
		l1.print();
		l2.print();
		
		LinkedList l3 = obj.sumOfTwoList(l1,l2);
		l3.print();
	}
}

