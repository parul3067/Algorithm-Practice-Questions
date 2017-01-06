package tree;

public class TreeNode<T> {
	T data;
	TreeNode<T> left, right;
	boolean visited = false;
	
	public TreeNode(T data) {
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
