package StackAndQueue;

public class NextGreaterElement {
	
	private void findNextGreaterElementUsingArray(int input[]) {
		int lastIndex = input.length - 1;
		int maxSoFar = input[lastIndex];
		System.out.println("Next Greater Element for "+input[lastIndex]+" : -1");
		
		for(int i = lastIndex - 1;i>=0;i--) {
			if(input[i] < input[i+1]) {
				System.out.println("Next Greater Element for "+input[i]+" : "+input[i+1]);
			} else if(input[i] < maxSoFar) {
				System.out.println("Next Greater Element for "+input[i]+" : "+maxSoFar);
			} else {
				System.out.println("Next Greater Element for "+input[i]+" : -1");
				maxSoFar = input[i];
			}
		}
	}
	
	private void findNextGreaterElementUsingStack(int input[]) {
		Stack<Integer> s = new Stack<>();
		s.push(input[0]);
		int nextGreaterElement = -1;
		for(int i=1;i<input.length;i++) {
			nextGreaterElement = input[i];
			while(!s.isEmpty()) {
				if(s.peek().data < nextGreaterElement) {
					System.out.println("NGE for element "+s.pop().data+" is "+nextGreaterElement);
				} else {
					s.push(nextGreaterElement);
					break;
				}
			}
			if(s.isEmpty()) {
				s.push(nextGreaterElement);
			}
		}
		
		while(!s.isEmpty()) {
			System.out.println("NGE for element "+s.pop().data+" is -1");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextGreaterElement obj = new NextGreaterElement();
		int inputArray[] = {2,4,1,3,5,10}; 
		
		obj.findNextGreaterElementUsingStack(inputArray);
		obj.findNextGreaterElementUsingArray(inputArray);
	}

}
