package binarySearchTree;

public class LCA {
	TreeNode root = null;
	
	private void insert(int value) {
		this.root = insertInTree(this.root, value);
	}
	
	private TreeNode insertInTree(TreeNode root, int value) {
		if(root == null) {
			TreeNode newNode = new TreeNode(value);
			return newNode;
		} else {
			if(root.data > value) {
				root.left = insertInTree(root.left, value);
			} else {
				root.right = insertInTree(root.right, value);
			}
			
			return root;
		}
	}
	
	private void inOrder(TreeNode root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	
	private TreeNode findLCA(TreeNode root, int a, int b) {
		if(root == null) {
			return null;
		} else if (Math.max(a, b) < root.data) {
			return findLCA(root.left, a, b);
		} else if(Math.min(a, b) > root.data) {
			return findLCA(root.right, a, b);
		} else {
			return root;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCA tree = new LCA();
		tree.insert(20);
		tree.insert(8);
		tree.insert(22);
		tree.insert(4);
		tree.insert(12);
		tree.insert(10);
		tree.insert(14);
		
		TreeNode lca = tree.findLCA(tree.root,8,14);
		System.out.println("Lowest common ancestor : "+lca.data);
	}

}
