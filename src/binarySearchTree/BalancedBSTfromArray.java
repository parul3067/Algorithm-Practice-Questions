package binarySearchTree;

public class BalancedBSTfromArray {
	TreeNode root;
	
	private TreeNode constructTree(int a[],int start, int end) {
		if(start > end) {
			return null;
		}
		int mid = (end + start)/2;
		TreeNode node = new TreeNode(a[mid]);
		node.left = constructTree(a, start, mid-1);
		node.right = constructTree(a, mid+1, end);
		
		return node;
	}
	
	private void preOrder(TreeNode root) {
		if(root != null) {
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedBSTfromArray tree = new BalancedBSTfromArray();
		int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		tree.root = tree.constructTree(a,0,a.length-1);
		tree.preOrder(tree.root);
	}

}
