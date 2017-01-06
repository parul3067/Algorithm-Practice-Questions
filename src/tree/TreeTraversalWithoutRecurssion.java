package tree;

import java.util.ArrayList;
import java.util.Stack;

public class TreeTraversalWithoutRecurssion<T> {
	
	TreeNode<T> root;
	
	
	public TreeTraversalWithoutRecurssion() {
		this.root = null;
	}
	
	public TreeTraversalWithoutRecurssion(T root) {
		this.root = new TreeNode<T>(root);
	}
	
	private ArrayList<TreeNode<T>> preOrderTraversal(TreeNode<T> root) {
		ArrayList<TreeNode<T>> list = new ArrayList<TreeNode<T>>();
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		TreeNode<T> currentNode = this.root;
		while(true) {
			if(currentNode != null) {
				list.add(currentNode);
				stack.push(currentNode);
				currentNode = currentNode.left;
			} else {
				if(stack.isEmpty()) {
					break;
				} else {
					currentNode = stack.pop();
					currentNode = currentNode.right;
				}
			}
		}
		
		return list;
	}
	
	private ArrayList<TreeNode<T>> inOrderTraversal(TreeNode<T> root) {
		ArrayList<TreeNode<T>> list = new ArrayList<TreeNode<T>>();
		TreeNode<T> currentNode = root;
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		while(true) {
			if(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			} else {
				if(stack.isEmpty()) {
					break;
				} else {
					currentNode = stack.pop();
					list.add(currentNode);
					currentNode = currentNode.right;
				}
			}
		}
		
		return list;
	}
	
	private ArrayList<TreeNode<T>> postOrderTraversal(TreeNode<T> root) {
		ArrayList<TreeNode<T>> list = new ArrayList<TreeNode<T>>();
		TreeNode<T> currentNode = root;
		Stack<TreeNode<T>> stack1 = new Stack<TreeNode<T>>();
		stack1.push(currentNode);
		Stack<TreeNode<T>> stack2 = new Stack<TreeNode<T>>();
		while(!stack1.isEmpty() ) {
			currentNode = stack1.pop();
			stack2.push(currentNode);
			
			if(currentNode.left != null) {
				stack1.push(currentNode.left);
			}
			if(currentNode.right != null) {
				stack1.push(currentNode.right);
			}
		}
		
		while(!stack2.isEmpty()) {
			list.add(stack2.pop());
		}
		
		return list;
	}
	
	public boolean childrenVisited(TreeNode node) {
		boolean childrenVisited = false;
		if(node.left != null && node.right != null) {
			childrenVisited = node.left.isVisited() && node.right.isVisited();
		} else if(node.left == null && node.right != null) {
			childrenVisited = node.right.isVisited();
		} else if(node.left != null && node.right == null) {
			childrenVisited = node.left.isVisited();
		} else {
			childrenVisited = true;
		}
		
		return childrenVisited;
	}
	private ArrayList<TreeNode<T>> postOrderTraversalSingleStack(TreeNode<T> root) {
		ArrayList<TreeNode<T>> list = new ArrayList<TreeNode<T>>();
		TreeNode<T> currentNode = root;
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		stack.push(currentNode);
		while(!stack.isEmpty()) {
			currentNode = stack.peek();
			if((currentNode.left == null && currentNode.right == null) || 
					(childrenVisited(currentNode)/*currentNode.left.isVisited() && currentNode.right.isVisited()*/)) {
				currentNode = stack.pop();
				currentNode.setVisited(true);
				list.add(currentNode);
			} else {
				if(currentNode.right != null) {
					stack.push(currentNode.right);
				}
				if(currentNode.left != null) {
					currentNode = currentNode.left;
					stack.push(currentNode);
				}
			}
		}
		
		return list;
	}
	
	private void printList(ArrayList<TreeNode<T>> list) {
		for(TreeNode<T> node : list) {
			System.out.print(node.data+" ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeTraversalWithoutRecurssion<Integer> tree = new TreeTraversalWithoutRecurssion<Integer>(1);
		if(tree.root != null) {
			tree.root.left = new TreeNode<Integer>(2);
			tree.root.right = new TreeNode<Integer>(3);
			tree.root.left.left = new TreeNode<Integer>(4);
			tree.root.left.right = new TreeNode<Integer>(5);
			tree.root.left.right.left = new TreeNode<Integer>(8);
			tree.root.left.right.right = new TreeNode<Integer>(9);
			tree.root.right.left = new TreeNode<Integer>(6);
			tree.root.right.right = new TreeNode<Integer>(7);
			tree.root.right.right.left = new TreeNode<Integer>(10);
			tree.root.right.right.right = new TreeNode<Integer>(11);
		}
		ArrayList<TreeNode<Integer>> list = new ArrayList<TreeNode<Integer>>();
		System.out.println("Pre Order");
		list = tree.preOrderTraversal(tree.root);
		tree.printList(list);
		System.out.println();
		
		System.out.println("In Order");
		list = tree.inOrderTraversal(tree.root);
		tree.printList(list);
		System.out.println();
		
		System.out.println("Post Order using 2 stacks");
		list = tree.postOrderTraversal(tree.root);
		tree.printList(list);
		System.out.println();
		
		System.out.println("Post Order using 1 stack");
		list = tree.postOrderTraversalSingleStack(tree.root);
		tree.printList(list);
	}

}
