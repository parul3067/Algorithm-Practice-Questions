package StackAndQueue;

public class Stack<T extends Comparable<T>> {
	StackNode<T> top;
	T minimum;
	
	Stack() {}
	
	public void push(T data) {
		StackNode<T> newNode = new StackNode<>(data);
		if(top == null) {
			top = newNode;
			minimum = top.data;
		} else {
			if(newNode.data.compareTo(minimum) < 0) {
				minimum = newNode.data; 
			}
			newNode.next = top;
			top = newNode;
		}
	}
	
	public StackNode<T> pop() {
		if(top != null) {
			StackNode<T> poppedElement = this.top;
			top = top.next;
			
			return poppedElement;
		}
		
		return null;
	}
	
	public <T>T getMin() {
		return (T)minimum;
	}
	
	public void print() {
		if(this.top == null) {
			System.out.println("Empty Stack"); 
		} else {
			StackNode<T> iterator = this.top;
			while(iterator.next != null) {
				System.out.print(iterator.data+"->");
				iterator = iterator.next;
			}
			System.out.println(iterator.data);
		}
	}
	
	public int getSize() {
		int size = 0;
		StackNode<T> iterator = top;
		if(iterator == null) {
			size = 0;
		} else {
			while(iterator != null) {
				iterator = iterator.next;
				size++;
			}
		}
		
		return size;
	}
	
	public boolean isEmpty() {
		return (top == null);
	}
	
	public StackNode<T> peek() {
		return this.top;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<Integer>();
		s.push(45);
		s.push(3);
		s.push(6);
		s.push(15);
		s.push(4);
		s.push(10);
		s.push(5);
		s.print();
		System.out.println("Popped element "+s.pop().data);
		s.print();
		System.out.println("Minimum is :"+s.getMin());
		System.out.println("Top element "+s.peek().data);
		System.out.println("Is stack empty? "+s.isEmpty());
	}

}
