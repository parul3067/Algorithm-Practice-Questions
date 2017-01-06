package StackAndQueue;

class Result {
	boolean isValidSting;
	int lengthOfValidString;
	
	Result(boolean isValid, int length) {
		this.isValidSting = isValid;
		this.lengthOfValidString = length;
	}
}

public class BalancingInParanthesis {
	
	Stack<Character> s = new Stack<>();
 	private Result findBalancingInExpression(String input) {
		boolean isInputBalanced = true;
		char inputCharacter;
		int lengthOfValidString = 0;
		for(int i=0;i<input.length();i++) {
			inputCharacter = input.charAt(i);
			if(inputCharacter == '(' || inputCharacter == '[' || inputCharacter == '{') {
				s.push(inputCharacter);
			} else if (inputCharacter == ')') {
				if(s.isEmpty() || s.peek().data != '(') {
					isInputBalanced = false;
					//break;
				} else {
					s.pop();
					lengthOfValidString += 2;  // 2 for both the opening and closing brace
				}
			} else if (inputCharacter == ']') {
				if(s.isEmpty() || s.peek().data != '[') {
					isInputBalanced = false;
					//break;
				} else {
					s.pop();
					lengthOfValidString += 2;
				}
			} else if (inputCharacter == '}') {
				if(s.isEmpty() || s.peek().data != '{') {
					isInputBalanced = false;
					//break;
				} else {
					s.pop();
					lengthOfValidString += 2;
				}
			}
		}
		
		if(!s.isEmpty())
			isInputBalanced = false;
		
		return new Result(isInputBalanced, lengthOfValidString);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputString = "{()}[]";
		BalancingInParanthesis obj = new BalancingInParanthesis();
		Result result = obj.findBalancingInExpression(inputString);
		System.out.println("Is this string balanced ? "+result.isValidSting);
		System.out.println("Maximum length of valid string :"+result.lengthOfValidString);
	}

}
