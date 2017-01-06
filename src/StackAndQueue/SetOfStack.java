package StackAndQueue;

import java.util.ArrayList;



abstract class BasicStack {

	public abstract void push(int a);
	public abstract void pop();
	
}

class SetOfStack<T> extends BasicStack {
	ArrayList<Stack<Integer>> stackList = new ArrayList<Stack<Integer>>();
	int capacity;
	int numStack = 0;
	
	public SetOfStack(int capacity) {
		this.capacity = capacity;
	}
	
	public Stack getLastStack() {
		int listSize = stackList.size();
		if(listSize == 0) {
			return null;
		} else {
			return stackList.get(numStack);
		}
	}
	
	public void push(int data) {
		Stack<Integer> tempStack = getLastStack();

		if(tempStack == null) {
			Stack<Integer> newStack = new Stack<Integer>();
			newStack.push(data);
			stackList.add(newStack);
		} else {
			if(tempStack.getSize() < capacity) {
				tempStack.push(data);
			} else {
				Stack<Integer> newStack = new Stack<Integer>();
				newStack.push(data);
				stackList.add(newStack);
				numStack++;
			}
		}
		
	}
	
	public void pop() {
		Stack s = getLastStack();
		s.pop();
		if(s.getSize() == 0) {
			stackList.remove(s);
			numStack--;
		}
	}
	
	public void peek() {
		System.out.println("Top element of stack :"+getLastStack().top.data);
	}
	
	public void printAll() {
		for(Stack s : stackList) {
			s.print();
		}
	}
	public static void main(String args[]) {
		int MAX_SIZE = 3;
		SetOfStack<Integer> sos = new SetOfStack<Integer>(MAX_SIZE);
		sos.push(1);
		sos.push(2);
		sos.push(3);
		sos.push(4);
		sos.push(5);
		sos.push(6);
		sos.push(7);
		sos.push(8);
		sos.push(9);
		sos.push(10);
		sos.printAll();
		sos.pop();
		sos.pop();
		sos.printAll();
		sos.peek();
		sos.pop();
		sos.pop();
		sos.printAll();
	}
}

