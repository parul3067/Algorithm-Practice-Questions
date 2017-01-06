package tree;

public class MaximumWidth<T> {
	
	TreeNode<T> root;
	
	public MaximumWidth() {
		this.root = null;
	}
	
	public MaximumWidth(T data) {
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
	
	private int findWidth(TreeNode<T> root) {
		int levels = getHeight(root);
		System.out.println("height "+levels);
		int maxWidth = 0;
		for(int i=1;i<=levels;i++) {
			int widthAtEachLevel = getWidthAtEachLevel(root, i);
			if(widthAtEachLevel > maxWidth) {
				maxWidth = widthAtEachLevel;
			}
		}
			
		return maxWidth;
	}
	
	private int getWidthAtEachLevel(TreeNode<T> root, int level) {
		int left = 0;
		int right = 0;
		if(root == null) {
			return 0;
		} else {
			if(level == 1) {
				return 1;
			} else {
				 left += getWidthAtEachLevel(root.left, level - 1);
				 right += getWidthAtEachLevel(root.right, level - 1);
			}
		}
			
		return (left+right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumWidth<Integer> tree = new MaximumWidth<Integer>(1);
		if(tree.root != null) {
			tree.root.left = new TreeNode<Integer>(2);
			tree.root.right = new TreeNode<Integer>(3);
			tree.root.left.left = new TreeNode<Integer>(4);
			tree.root.left.right = new TreeNode<Integer>(5);
			tree.root.left.left.left = new TreeNode<Integer>(6);
			tree.root.left.left.right = new TreeNode<Integer>(7);
			tree.root.left.right.left = new TreeNode<Integer>(8);
			tree.root.left.right.right = new TreeNode<Integer>(9);
			tree.root.right.left = new TreeNode<Integer>(10);
			tree.root.right.right = new TreeNode<Integer>(11);
			tree.root.right.left.left = new TreeNode<Integer>(12);
			tree.root.right.left.right = new TreeNode<Integer>(13);
			tree.root.right.right.left = new TreeNode<Integer>(14);
			tree.root.right.right.right = new TreeNode<Integer>(15);
			tree.root.right.right.right.right = new TreeNode<Integer>(12);
		}
		
		int maxWidth = tree.findWidth(tree.root);
		
		System.out.println("Maximum width :"+maxWidth);
	}

}
