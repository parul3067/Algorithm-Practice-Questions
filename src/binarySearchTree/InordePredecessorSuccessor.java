package binarySearchTree;

class Result {
	int inorderPredecessor = -1;
	int inorderSuccessor = -1;
	
	Result(int inorderPredecessor, int inorderSuccessor) {
		this.inorderPredecessor = inorderPredecessor;
		this.inorderSuccessor = inorderSuccessor;
	}
}

public class InordePredecessorSuccessor {
	TreeNode root;
	Result mResult;
	
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
	
	private int findMaxInLeft(TreeNode root) {
		while(root.right !=  null) {
			root = root.right;
		}
		
		return root.data;
	}
	
	private int findMinInRight(TreeNode root) {
		while(root.left !=  null) {
			root = root.left;
		}
		
		return root.data;
	}
	
	private TreeNode findInOrderSuccPree(TreeNode root, int key) {
		if(root == null) {
			return null;
		} else {
			if(root.data == key) {
				int predecessor = findMaxInLeft(root.left);
				int successor = findMinInRight(root.right);
				mResult = new Result(predecessor, successor);
			} else {
				if(key < root.data) {
					root.left = findInOrderSuccPree(root.left, key);
				} else {
					root.right = findInOrderSuccPree(root.right, key);
				}
			}
		}
		
		return root;
	}
	
	private Result inOrderSuccPree(int key) {
		TreeNode temp = findInOrderSuccPree(root, key);
		
		return mResult;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InordePredecessorSuccessor tree = new InordePredecessorSuccessor();
		tree.insert(50);
		tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
        int key = 75;
        Result result = tree.inOrderSuccPree(key);
        System.out.println("predecessor :"+result.inorderPredecessor+" | successor :"+result.inorderSuccessor);
	}

}
