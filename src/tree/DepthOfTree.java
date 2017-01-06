package tree;

public class DepthOfTree<T> {
	TreeNode<T> root;
	public DepthOfTree() {
		this.root = null;
	}
	
	public DepthOfTree(T data) {
		this.root =  new TreeNode<T>(data);
	}
	
	private int findDepth(TreeNode<T> root) {
		if(root == null) {
			return 0;
		}
		
		int leftDepth = findDepth(root.left);
		int rightDepth = findDepth(root.right);
		System.out.println("left height :"+leftDepth);
		System.out.println("right height :"+rightDepth);
		
		return (leftDepth >= rightDepth) ? (leftDepth+1):(rightDepth+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DepthOfTree<Integer> tree = new DepthOfTree<Integer>(1);
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
		
		int depth = tree.findDepth(tree.root);
		System.out.println("Depth of tree is :"+depth);
	}

}
