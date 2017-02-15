package array;

import org.omg.CORBA.MARSHAL;

public class DynamicArray {
	
	final static int MAX_SIZE = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[MAX_SIZE];
		int index = 0;
		for(int i=0;i<=10;i++) {
			if(a.length < MAX_SIZE) {
				a[index++] = i;
			} else {
				int temp[] = new int[a.length];
				for(int j = 0;j<a.length;j++) {
					temp[j] = a[j];
				}
				int newSize = a.length + MAX_SIZE/2;
				a = new int[newSize];
				for(int j=0;j<temp.length;j++) {
					a[j] = temp[j];
				}
				a[index++] = i;
			}
		}
		
		for(int i=0;i<index;i++) {
			System.out.print(a[i]+" ");
		}

	}

}
