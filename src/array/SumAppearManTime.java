package array;

public class SumAppearManTime {
	
	private static int findNum(int a[]) {
		int NUM=a[0];
		int maxSoFar=0;
		int count = 0;
		int noToCompare = a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i] == noToCompare) {
				count++;
			} else {
				if(count > maxSoFar) {
					NUM = a[i-1];
					maxSoFar = count;
				}
				count = 1;
				noToCompare = a[i];
			}
		}
		if(count > maxSoFar) {
			NUM = a[a.length - 1];
			maxSoFar = count;
		}
		
		return NUM;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,3,3,3,3,3,4,5,5,5,5,5,5};
		int num = findNum(a);
		System.out.println("no :"+num);
	}

}
