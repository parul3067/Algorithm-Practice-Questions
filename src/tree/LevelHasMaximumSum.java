package tree;

class Result {
	int level;
	int sum;
	
	public Result() {
		
	}
	
	public Result(int level, int sum) {
		this.level = level;
		this.sum = sum;
	}
}

public class LevelHasMaximumSum {
	TreeNode root;
	
	public LevelHasMaximumSum() {
		this.root = null;
	}
	
	public LevelHasMaximumSum(int data) {
		this.root =  new TreeNode(data);
	}
	
	private int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int leftDepth = getHeight(root.left);
		int rightDepth = getHeight(root.right);
		
		return ((leftDepth >= rightDepth) ? (leftDepth + 1) : (rightDepth + 1));
	}
	
	private int getSumAtEachLevel(TreeNode root, int level) {
		int sum = 0;
		if(root == null) {
			return 0;
		} else {
			if(level == 1) {
				//return root.data;           // this program works fine but need to type cast generic to intger to get the result
			} else {							// or change the TreeNode from generic type to interger type.
				int left = getSumAtEachLevel(root.left, level - 1);
				int right = getSumAtEachLevel(root.right, level - 1);
				sum = left + right;
			}
		}
		
		return sum;
	}
	
	private Result findMaximumSumAndLevel(TreeNode root) {
		int levels = getHeight(root);
		int maxSumLevel = 0;
		int maxSum = 0;
		for(int i=1;i<=levels;i++) {
			int sum = getSumAtEachLevel(root, i);
			if(sum > maxSum) {
				maxSum = sum;
				maxSumLevel = i;
			}
		}
			
		return new Result(maxSumLevel, maxSum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevelHasMaximumSum tree = new LevelHasMaximumSum(1);
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
		Result result = tree.findMaximumSumAndLevel(tree.root);
		
		System.out.println("Level :"+result.level+" and Maximum Sum :"+result.sum);
	}

}
