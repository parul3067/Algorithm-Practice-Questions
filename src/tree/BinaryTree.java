package tree;

public class BinaryTree<T> {
	TreeNode<T> root;
	int size = 0;
	
	public BinaryTree(){
		
	}
	
	public BinaryTree(T root) {
		this.root = new TreeNode<T>(root);
	}
	
	public void preOrderTraversal(TreeNode<T> node) {
		if(node != null) {
			System.out.print(node.data+" ");
			size++;
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	public void postOrderTraversal(TreeNode<T> node) {
		if(node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.data+" ");
		}
	}
	
	public void inOrderTraversal(TreeNode<T> node) {
		if(node != null) {
			postOrderTraversal(node.left);
			System.out.print(node.data+" ");
			postOrderTraversal(node.right);
		}
	}
	
	public int sizeOf(TreeNode<T> node) {
		if(node == null) {
			return 0;
		} else {
			System.out.println("node :"+node.data);
			return (sizeOf(node.left) + 1 + sizeOf(node.right));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> tree = new BinaryTree<Integer>(1);
		if(tree.root != null) {
			tree.root.left = new TreeNode<Integer>(2);
			tree.root.right = new TreeNode<Integer>(3);
			tree.root.left.left = new TreeNode<Integer>(4);
			tree.root.left.right = new TreeNode<Integer>(5);
			tree.root.right.left = new TreeNode<Integer>(6);
			tree.root.right.right = new TreeNode<Integer>(7);
		}
		
		System.out.println("PreOrderTraversal :");
		tree.preOrderTraversal(tree.root);
		System.out.println();
		System.out.println();
		
		System.out.println("PostOrderTraversal :");
		tree.postOrderTraversal(tree.root);
		System.out.println();
		System.out.println();
		
		System.out.println("InOrderTraversal :");
		tree.inOrderTraversal(tree.root);
		System.out.println();
		System.out.println();
		System.out.println("Size of tree is :"+tree.size);
		
		int sizeOfTree = tree.sizeOf(tree.root);
		System.out.println("size of tree :"+sizeOfTree);
	}

}
