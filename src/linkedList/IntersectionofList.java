package linkedList;

import java.util.HashMap;

public class IntersectionofList {
	
	private static void findIntersection(LinkedList list1, LinkedList list2) {
		Node head1 = list1.head;
		Node head2 = list2.head;
		while(head1 != null) {
			head1.setVisited(true);
			//System.out.println("list 1 data : "+head1.data);
			head1 = head1.next;
		}
		while(head2 != null) {
			if(head2.isVisited()) {
				//System.out.println("intersection point "+head2.data);
				System.out.println("Intersection point : Method 2 :"+head2.data);
				break;
			} else {
				head2.setVisited(true);
				//System.out.println("list 2 data : "+head2.data);
				head2 = head2.next;
			}
		}
	}
	
	private static void findIntersectionUsingHash(LinkedList list1, LinkedList list2) {
		HashMap<Node,Object> hm = new HashMap<>();
		Node head1 = list1.head;
		Node head2 = list2.head;
		while(head1!=null) {
			hm.put(head1, head1.data);
			head1 = head1.next;
		}
		while(head2 != null) {
			if(hm.containsKey(head2)) {
				System.out.println("Intersection point : Method 1 :"+head2.data);
				break;
			} else {
				head2 = head2.next;
			}
		}
		
	}
	
	private static int getLength(Node head1) {
        Node head = head1;
        int size = 1;
        if(head == null) {
            return 0;
        }
        while(head != null) {
            size++;
            head = head.next;
        }
    
        return size;
    }

    private static Node chopOffExtra(int d, Node node) {
        for(int i=0;i<d;i++) {
            node = node.next;
        }
    
        return node;
    }
    
    private static void getIntersectionNode(Node headA, Node headB) {
        int lenA = getLength(headA);
		int lenB = getLength(headB);
		
		Node shortNode = (lenA<lenB)?headA:headB;
		Node largeNode = (lenA<lenB)?headB:headA;
		
		int chopOff = Math.abs(lenA - lenB);
		largeNode = chopOffExtra(chopOff, largeNode);
		
		while(shortNode != largeNode) {
		    shortNode = shortNode.next;
		    largeNode = largeNode.next;
		}
		System.out.println("Intersection Point : Method 3 :"+shortNode.data);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList<>();
		l1.add(1);
		l1.add(20);
		l1.add(5);
		l1.add(2);
		l1.add(6);
		LinkedList l2 = new LinkedList<>();
		l2.add(10);
		l2.add(20);
		l2.add(50);
		l2.head.next.next.next = l1.head.next.next.next;
		l1.print();
		l2.print();
		findIntersectionUsingHash(l1,l2);
		findIntersection(l1,l2);
		getIntersectionNode(l1.head,l2.head);
		
	}

}
