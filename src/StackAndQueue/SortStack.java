package StackAndQueue;

public class SortStack {
	Stack<Integer> sortedStack = new Stack<Integer>();
	
	private void sort(Stack<Integer> s) {
		int temp;
		if(!s.isEmpty()) {
			temp = s.pop().data;
			sort(s);
			insertSorted(sortedStack,temp);
		}
	}
	
	private void insertSorted(Stack<Integer> newStack, int data) {
		if(newStack.isEmpty()) {
			newStack.push(data);
		} else {
			if(newStack.peek().data > data) {
				newStack.push(data);
			} else {
				int temp = newStack.pop().data;
				insertSorted(newStack, data);
				newStack.push(temp);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortStack obj = new SortStack();
		Stack<Integer> s = new Stack<Integer>();
		s.push(10);
		s.push(2);
		s.push(35);
		s.push(4);
		s.push(5);
		s.print();
		System.out.println("After sort");
		obj.sort(s);
		obj.sortedStack.print();
		
	}

}
