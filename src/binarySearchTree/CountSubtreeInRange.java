package binarySearchTree;
import java.util.Queue;

import java.util.LinkedList;

public class CountSubtreeInRange {
	TreeNode root;
	int mCount = 0;
	int lowerIndex = 5;
	int higherIndex = 45;
	
	private void insert(int data) {
		this.root = insertIntoTree(this.root, data);
	}
	
	private TreeNode insertIntoTree(TreeNode root, int data) {
		if(root == null) {
			root = new TreeNode(data);
			return root;
		} else {
			if(root.data > data) {
				root.left = insertIntoTree(root.left, data);
			} else {
				root.right = insertIntoTree(root.right, data);
			}
		}
		
		return root;
	}
	
	private boolean inRange(TreeNode root) {
		boolean inRange = true;
		TreeNode temp;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			temp = queue.poll();
			if(temp.data < lowerIndex || temp.data > higherIndex) {
				inRange = false;
				break;
			}
			if(temp.left != null) {
				queue.add(temp.left);
			}
			if(temp.right != null) {
				queue.add(temp.right);
			}
		}
		
		return inRange;
	}
	
	private TreeNode findSubtreeCount(TreeNode root) {
		if(root == null) {
			return null;
		} else {
			root.left = findSubtreeCount(root.left);
			root.right = findSubtreeCount(root.right);
			if(inRange(root)) {
				mCount++;
			}
		}
		
		return root;
	}
	
	private int getCount() {
		return mCount;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountSubtreeInRange tree = new CountSubtreeInRange();
		tree.insert(10);
		tree.insert(5);
		tree.insert(1);
		tree.insert(50);
		tree.insert(40);
		tree.insert(100);
		
		tree.findSubtreeCount(tree.root);
		System.out.println("Total subtree in given range : "+tree.getCount());
	}

}
