package StackAndQueue;

public class ReverseStack {
	
	StackNode newTop;
	private StackNode reverseStack(StackNode top, StackNode prev) {
		if(top.next == null) {
			top.next = prev;
			newTop = top;
			return null;
		}
		StackNode next = top.next;
		top.next = prev;
		top = reverseStack(next, top);
		
		return newTop;
	}
	private Stack reverse(Stack s) {
		StackNode top = reverseStack(s.peek(),null);
		s.top = top;
		return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseStack obj = new ReverseStack();
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.print();
		s = obj.reverse(s);
		System.out.println("After reverse");
		s.print();
		System.out.println("Top element :"+s.peek().data);
	}

}
