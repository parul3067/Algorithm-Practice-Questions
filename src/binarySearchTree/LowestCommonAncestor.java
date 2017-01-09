package binarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;

public class LowestCommonAncestor {
	TreeNode root;
	boolean hasCommonAncestorFound = false;
	int leastCommonAncestor;
	ArrayList<Integer> ancestorList = new ArrayList<Integer>();
	
	private void insert(int data) {
		this.root = insertInTree(root,data);
	}
	
	private TreeNode insertInTree(TreeNode root, int data) {
		if(root == null) {
			root = new TreeNode(data);
			return root;
		} else {
			if(data < root.data) {
				root.left = insertInTree(root.left, data);
			} else {
				root.right = insertInTree(root.right, data);
			}
			return root;
		}
	}
	
	private void preOrder(TreeNode root) {
		if(root != null) {
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	private boolean isPresent(int data) {
		if(ancestorList.isEmpty()) {
			return false;
		} else {
			for(int x : ancestorList) {
				if(x == data) {
					return true;
				}
			}
			
			return false;
		}
	}
	
	private boolean findAncestor(TreeNode root, int data) {
		if(root == null)
			return false;
		
		if(root.data == data) {
			//System.out.print(root.data+" ");
			if(isPresent(root.data)) {
				if(!hasCommonAncestorFound) {
					leastCommonAncestor = root.data;
					hasCommonAncestorFound = true;
				}
			} else {
				ancestorList.add(root.data);
			}
			
			return true;
		}
		
		if(findAncestor(root.left, data) || findAncestor(root.right, data)) {
			//System.out.print(root.data+" ");
			if(isPresent(root.data)) {
				if(!hasCommonAncestorFound) {
					leastCommonAncestor = root.data;
					hasCommonAncestorFound = true;
				}
			} else {
				ancestorList.add(root.data);
			}
			return true;
		}
		
		return false;
	}
	
	private void printList() {
		for(int x : ancestorList) {
			System.out.print(x+" ");
		}
		System.out.println();
	}
	
	private void findLeastCommonAncestor(int key1, int key2) {
		boolean ancestor1 = findAncestor(root, key1);
		boolean ancestor2 = findAncestor(root, key2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.insert(20);
		tree.insert(8);
		tree.insert(22);
		tree.insert(4);
		tree.insert(12);
		tree.insert(10);
		tree.insert(14);
		
		//tree.preOrder(tree.root);
		//System.out.println("Ancestors are:");
		tree.findLeastCommonAncestor(8,14);
		
		System.out.println("Least common ancestor of 8 and 14 is : "+tree.leastCommonAncestor);
	}

}
