package StackAndQueue;

public class StackWithMiddleOperation {
	DDLNode top;
	DDLNode middle;
	int size = 0;
	
	private void pop() {
		System.out.println("Element popped is :"+top.data);
		if(top.right == null) {
			top = middle = null;
		} else {
			top.right.left = top.left;
			top.right = top;
		}
		
	}
	
	private void peek() {
		System.out.println("Top Element is :"+top.data);
	}
	
	private void push(int data) {
		size++;
		DDLNode node = new DDLNode(data);
		if(top == null) {
			top = middle = node;
		} else {
			node.right = top;
			top.left = node;
			top = node;
			if(size%2 == 0) {
				middle = middle.left;
			}
			
		}
	}
	
	private void getMiddle() {
		System.out.println("Middle element of the stack :"+middle.data);
	}
	
	private void deleteMiddle() {
		System.out.println("Element deleted :"+middle.data);
		if(middle.right != null) {
			middle.right.left = middle.left;
		}
		if(middle.left != null) {
			middle.left.right = middle.right;
		}
		
		// Need to update middle element
		if(size%2==0) {
			middle = middle.right;
		} else {
			middle = middle.left;
		}
		size--;
		if(size == 1) {
			top = middle;
		}
	}
	
	private void print() {
		DDLNode iterator = top;
		
		if(iterator == null) {
			System.out.println("Empty Stack");
		} else {
			while(iterator.right != null) {
				System.out.print(iterator.data+"->");
				iterator = iterator.right;
				iterator.left = null;
			}
			System.out.println(iterator.data);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackWithMiddleOperation s = new StackWithMiddleOperation();
		s.push(1);
		s.push(2);
		s.print();
		s.getMiddle();
		//s.deleteMiddle();
		//s.print();
		s.push(3);
		//s.print();
		//s.getMiddle();
		s.push(4);
		s.print();
		s.getMiddle();
		s.push(5);
		s.print();
		s.getMiddle();
		s.deleteMiddle();
		//s.print();

	}

}
