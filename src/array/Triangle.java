package array;

public class Triangle {

	private void printTriangle(int height) {
		int row = height;
		int column = 2*height - 1;
		char a[][] = new char[row][column];
		int middle = (column)/2;
		for(int rowIndex = 0; rowIndex < row; rowIndex++) {
			a[rowIndex][middle] = '*';
			for(int columnIndex = 1; columnIndex <= rowIndex; columnIndex++) {
				a[rowIndex][middle - columnIndex] = '*';
				a[rowIndex][middle + columnIndex] = '*';
			}
		}
		
		for(int rowIndex = 0; rowIndex < row; rowIndex++) {
			for(int columnIndex = 0; columnIndex < column; columnIndex++) {
				if(a[rowIndex][columnIndex] != '*') {
					System.out.print(" ");
				} else {
					System.out.print(a[rowIndex][columnIndex]);
				}
			}
			System.out.println();
		}
		
	}
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		Triangle triangle = new Triangle();
		int height = 8;
		triangle.printTriangle(height);
		
	}

}
