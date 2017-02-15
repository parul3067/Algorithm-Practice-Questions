package tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

import javax.xml.transform.Templates;

public class RootToLeafPath<T> {
	TreeNode<T> root;
	ArrayList<TreeNode<T>> listOfPath = new ArrayList<TreeNode<T>>();	
	
	public RootToLeafPath() {
		this.root = null;
	}
	
	public RootToLeafPath(T data) {
		this.root =  new TreeNode<T>(data);
	}
	
	
	private Stack<TreeNode<T>> print(Stack<TreeNode<T>> stack) {
		//Cloner cloner = new Cloner();
		Stack<TreeNode<T>> temp = new Stack<TreeNode<T>>();
		
		while(!stack.isEmpty()) {
			temp.push(stack.pop());
		}
		
		while(!temp.isEmpty()) {
			System.out.print(temp.peek().data+" ");
			stack.push(temp.pop());
		}
		System.out.println();
		return stack;
	}
	
	private void printRootToLeavesPath(TreeNode<T> root) {
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		Stack<TreeNode<T>> path = new Stack<TreeNode<T>>();
		stack.push(root);
		TreeNode<T> current;
		while(!stack.isEmpty()) {
			current = stack.peek();
			if(!path.isEmpty() && current == path.peek()) {
				if(current.right == null && current.left == null) {
					path = print(path);
				}
				stack.pop();
				path.pop();
			} else {
				path.push(current);
				if(current.right != null) {
					stack.push(current.right);
				}
				if(current.left != null) {
					stack.push(current.left);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RootToLeafPath<Integer> tree = new RootToLeafPath<Integer>(1);
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
			tree.root.right.right.right.right = new TreeNode<Integer>(12);
		}
		
		tree.printRootToLeavesPath(tree.root);

	}

}
