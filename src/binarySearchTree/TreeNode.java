package binarySearchTree;

public class TreeNode {
	int data;
	TreeNode left, right;
	boolean visited = false;
	
	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public void setVisited(boolean isVisited) {
		this.visited = true;
	}
	
	public boolean isVisited() {
		return this.visited;
	}
}
