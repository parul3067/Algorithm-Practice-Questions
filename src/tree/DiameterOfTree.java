package tree;

public class DiameterOfTree<T> {
	TreeNode<T> root;
	int maxDiameter = -1;
	public DiameterOfTree() {
		this.root = null;
	}
	
	public DiameterOfTree(T data) {
		this.root =  new TreeNode<T>(data);
	}
	
	private int getHeight(TreeNode<T> root) {
		if(root == null) {
			return 0;
		}
		
		int leftDepth = getHeight(root.left);
		int rightDepth = getHeight(root.right);
		
		return ((leftDepth >= rightDepth) ? (leftDepth + 1) : (rightDepth + 1));
	}
	
	private  int findDiameter(TreeNode<T> root) {
		if(root == null) {
			return 0;
		}
		
		int diameterThroughRoot = getHeight(root.left) + getHeight(root.right) + 1;
		int diameterWithoutRoot = Math.max(findDiameter(root.left), findDiameter(root.right));
		
		return ((diameterThroughRoot > diameterWithoutRoot)? diameterThroughRoot : diameterWithoutRoot);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiameterOfTree<Integer> tree = new DiameterOfTree<Integer>(1);
		if(tree.root != null) {
			tree.root.left = new TreeNode<Integer>(2);
			tree.root.right = new TreeNode<Integer>(3);
			tree.root.left.left = new TreeNode<Integer>(4);
			tree.root.left.right = new TreeNode<Integer>(5);
			tree.root.left.left.left = new TreeNode<Integer>(6);
			tree.root.left.left.right = new TreeNode<Integer>(7);
			tree.root.left.left.right.left = new TreeNode<Integer>(8);
			tree.root.left.left.right.left.left = new TreeNode<Integer>(9);
			tree.root.left.left.right.left.right = new TreeNode<Integer>(10);
			tree.root.left.right.right = new TreeNode<Integer>(11);
			tree.root.left.right.right.left = new TreeNode<Integer>(12);
			tree.root.left.right.right.right = new TreeNode<Integer>(13);
			tree.root.left.right.right.right.right = new TreeNode<Integer>(14);
			tree.root.right.right = new TreeNode<Integer>(15);
			/*tree.root.left.right.left = new TreeNode<Integer>(8);
			tree.root.left.right.right = new TreeNode<Integer>(9);
			//tree.root.right.left = new TreeNode<Integer>(6);
			tree.root.right.right = new TreeNode<Integer>(7);
			tree.root.right.right.left = new TreeNode<Integer>(10);
			tree.root.right.right.right = new TreeNode<Integer>(11);
			tree.root.right.right.right.right = new TreeNode<Integer>(12);*/
		}
		int diameter = tree.findDiameter(tree.root);
		System.out.println("Diameter of tree :"+diameter);
	}

}
