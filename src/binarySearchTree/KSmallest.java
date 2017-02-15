package binarySearchTree;

public class KSmallest {

	TreeNode root;
	static int count=1;
	
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
	
	private void inOrder(TreeNode root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	
	
	private void findKSmallest(TreeNode root, int k) {
		if(root != null) {
			findKSmallest(root.left, k);
			if(k == count) {
				System.out.println("K smallest : "+root.data);
				count++;
			} else {
				count++;
			}
			findKSmallest(root.right, k);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KSmallest tree = new KSmallest();
		tree.insert(20);
		tree.insert(8);
		tree.insert(22);
		tree.insert(4);
		tree.insert(12);
		tree.insert(10);
		tree.insert(14);
		//tree.preOrder(tree.root);
		tree.inOrder(tree.root);
		System.out.println("");
		
		int k = 1;
		tree.findKSmallest(tree.root,k);
		//System.out.println("K smallest : "+number);
	}

}
