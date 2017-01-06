package linkedList;

public class Node<T> {
	T data;
	Node<T> next = null;
	boolean visited = false;
	
	Node(T data) {
		this.data = data;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean isVisited() {
		return this.visited;
	}
	
}
