package tree;


public class LevelOrderSpiral<T> {
	TreeNode<T> root;
	
	public LevelOrderSpiral() {
		this.root = null;
	}
	
	public LevelOrderSpiral(T data) {
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
	
	private void print(TreeNode<T> root, int level, boolean ltr) {
		if(root == null) {
			return;
		} else {
			if(level == 1) {
				System.out.print(root.data+" ");
			} else {
				if(ltr) {
					print(root.left, level - 1, ltr);
					print(root.right, level - 1, ltr);
				} else {
					print(root.right, level - 1, ltr);
					print(root.left, level - 1, ltr);
				}
			}
		}
		
	}
	
	private void printLevelOrderSpiral(TreeNode<T> root) {
		int treeHeight = getHeight(root);
		boolean ltr = false;
		for(int i=1 ; i<=treeHeight ; i++) {
			print(root,i,ltr);
			ltr = !ltr;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevelOrderSpiral<Integer> tree = new LevelOrderSpiral<Integer>(1);
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
		
		tree.printLevelOrderSpiral(tree.root);
	}

}
