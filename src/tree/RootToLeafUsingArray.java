package tree;

//  find all path that has sum a given number and print all of it

import java.util.ArrayList;

class NewResult {
	boolean isPathHasSum = false;
	int temp[] = new int[250];
	int index;
	
	NewResult(boolean value, int temp[], int index) {
		this.isPathHasSum = value;
		this.index = index;
		for(int i=0;i<index;i++) {
			this.temp[i] = temp[i];
		}
	}
}

public class RootToLeafUsingArray {
	
	Node root;
	ArrayList<NewResult> listOfResult = new ArrayList<NewResult>();
 	
	public RootToLeafUsingArray() {
		this.root = null;
	}
	
	public RootToLeafUsingArray(int data) {
		this.root =  new Node(data);
	}
	
	private void printPath(int temp[], int index, int sum) {
		for(int x = 0;x<index;x++) {
			System.out.print(temp[x]+" ");
		}
		System.out.println();
	}
	
	private void checkSum(int temp[], int index, int sum) {
		int localSum = 0;
		for(int x = 0;x<index;x++) {
			localSum += temp[x];
		}
		
		if(localSum == sum) {
			NewResult result = new NewResult(true, temp, index);
			listOfResult.add(result);
		}
	}
	
	private void rootToLeafPath(Node root,int temp[], int index, int sum) {
		temp[index++] = root.data;
		if(root.left == null && root.right == null) {
			printPath(temp,index, sum);
			checkSum(temp,index, sum);
		} else {
			
			if(root.left != null)
				rootToLeafPath(root.left,temp, index, sum);
			
			if(root.right != null)
				rootToLeafPath(root.right,temp, index, sum);
		}
	}
	
	private void rootToLeaf (Node root, int sum) {
		int temp[] = new int[250];
		rootToLeafPath(root,temp, 0, sum);
	}
	
	private void printAllPath(NewResult result) {
		for(int i=0;i<result.index;i++) {
			System.out.print(result.temp[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RootToLeafUsingArray tree = new RootToLeafUsingArray(1);
		if(tree.root != null) {
			tree.root.left = new Node(2);
			tree.root.right = new Node(3);
			tree.root.left.left = new Node(4);
			tree.root.left.right = new Node(5);
			tree.root.left.right.left = new Node(8);
			tree.root.left.right.right = new Node(9);
			tree.root.right.left = new Node(6);
			tree.root.right.right = new Node(7);
			tree.root.right.right.left = new Node(6);
			tree.root.right.right.right = new Node(11);
			tree.root.right.right.right.right = new Node(12);
		}
		
		int sum = 17;
		tree.rootToLeaf(tree.root, sum);
		
		if(tree.listOfResult.size() == 0) {
			System.out.println("No path has sum "+sum);
		} else {
			System.out.println("Paths with sum "+sum+": ");
			for(NewResult result : tree.listOfResult) {
				tree.printAllPath(result);
			}
		}
	}

}
