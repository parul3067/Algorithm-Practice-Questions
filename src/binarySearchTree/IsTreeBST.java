package binarySearchTree;


public class IsTreeBST {
	TreeNode root;
	TreeNode prev;
	
	public IsTreeBST() {
		this.root = null;
	}
	
	public IsTreeBST(int data) {
		this.root =  new TreeNode(data);
	}
	
	private boolean isTreeBST(TreeNode root) {
		if(root != null) {
			if(!isTreeBST(root.left))
				return false;
			
			if(prev != null && prev.data > root.data)
				return false;
			prev = root;
			if(!isTreeBST(root.right))
				return false;
		}
		
		return true;
	}
	
	private boolean isTreeBST() {
		prev = null;
		return isTreeBST(root);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsTreeBST tree = new IsTreeBST(4);
		if(tree.root != null) {
			tree.root.left = new TreeNode(2);
	        tree.root.right = new TreeNode(5);
	        tree.root.left.left = new TreeNode(1);
	        tree.root.left.right = new TreeNode(3);
		}
		
		if(tree.isTreeBST()) {
			System.out.println("Tree is BST");
		} else {
			System.out.println("No");
		}
	}

}
