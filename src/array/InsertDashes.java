package array;

public class InsertDashes {
	
	private static String removeDashes(String s, int k) {	
		s = s.replace("-", "").toUpperCase();
		int lengthOfInputString = s.length();
		
		int numOfGroups = (int) Math.floor(lengthOfInputString / k);
		
		int firstGroupLength = lengthOfInputString - numOfGroups * k;
		StringBuilder sb = new StringBuilder(s);
		int firstGroupIndex = 0;
		if(firstGroupLength != 0) {
			sb.insert(firstGroupLength, '-');		
			numOfGroups++;
			firstGroupIndex++;
		}
		
		for(int i = firstGroupLength + k + firstGroupIndex ; i < lengthOfInputString + numOfGroups -1; i += k + 1) {
			sb.insert(i, '-');
		}
		
		System.out.println("String "+sb.toString());
		return sb.toString();

	}
	
	private static String findSolutionMethod1(String input,int k) {
		input = input.replace("-", "").toUpperCase();
		System.out.println(input);
		int size = 0;
		int strLength = input.length();
		if(strLength%k == 0) {
			size = strLength / k;
		} else {
			size = strLength / k + 1;
		}
		
		String tempStr[] = new String[size];
		int iterator = 1, tempIndex=0;
		for(int i=strLength-1;i>=0;i--) {
			if(iterator <= k) {
				if(tempStr[tempIndex] == null) {
					System.out.println("char "+input.substring(i, i+1));
					tempStr[tempIndex] = input.substring(i, i+1);
				}else {
					tempStr[tempIndex] += input.charAt(i);
				}
				iterator++;
			} else {
				iterator = 1;
				i++;
				tempIndex++;
			}
		}
		for(int i=0;i<size;i++) {
			tempStr[i] = reverse(tempStr[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=size-1;i>=0;i--) {
			if(i>0) {
				tempStr[i] += '-';
			}
			sb.append(tempStr[i]);
		}
		System.out.println("String "+sb.toString());
		return input;
	}
	
	private static String reverse(String str) {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "2-4A0r7-4k";
		int k = 3;
		String solution = removeDashes(str, k);

	}

}
