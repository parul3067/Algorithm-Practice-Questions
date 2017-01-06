package tree;

public class Node {

	int data;
	Node left, right;
	boolean visited = false;
	
	public Node(int data) {
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
