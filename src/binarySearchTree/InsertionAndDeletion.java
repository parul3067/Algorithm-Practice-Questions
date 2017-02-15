package binarySearchTree;


public class InsertionAndDeletion {
	TreeNode root;
	
	public InsertionAndDeletion() {
		
	}
	
	public InsertionAndDeletion(int data) {
		root = new TreeNode(data);
	}
	
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
	
	private void preOrder(TreeNode root) {
		if(root != null) {
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	private int findMin(TreeNode root) {
		while(root.left != null) {
			root = root.left;
		}
		
		return root.data;
	}
	
	private TreeNode delete(TreeNode root, int data) {
		if(root == null) {
			return root;
		} 
		if(root.data == data) {
			if(root.left == null && root.right == null) {
				return null;
			} else if(root.left != null  && root.right == null) {  // only left child
				return root.left;
			} else if(root.right != null  && root.left == null) {  // only right child
				return root.right;
			} else {                                               // both children are present
				root.data = findMin(root.right);
				root.right = delete(root.right, root.data);
				return root;
			}
		} else {
			if(data < root.data) {
				root.left = delete(root.left, data);
			} else {
				root.right = delete(root.right, data);
			}
		}
		
		return root;
	}
	
	private void deleteNode(int data) {
		TreeNode tempRoot = this.root;
		tempRoot = delete(tempRoot, data);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionAndDeletion tree = new InsertionAndDeletion();
		tree.insert(50);
		tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.println("Preorder traversal");
        tree.preOrder(tree.root);
        
        System.out.println("\nDelete 20\n");
        tree.deleteNode(20);
        System.out.println("Preorder traversal of the modified tree \n");
        tree.preOrder(tree.root);
     
        System.out.println("\nDelete 30\n");
        tree.deleteNode(30);
        System.out.println("Preorder traversal of the modified tree \n");
        tree.preOrder(tree.root);
     
        System.out.println("\nDelete 50\n");
        tree.deleteNode(50);
        System.out.println("Preorder traversal of the modified tree \n");
        tree.preOrder(tree.root);
        
        
		
	}

}
