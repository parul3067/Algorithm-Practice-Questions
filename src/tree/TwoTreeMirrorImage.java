package tree;

public class TwoTreeMirrorImage<T> {
	
	TreeNode<T> root;
	
	public TwoTreeMirrorImage() {
		this.root = null;
	}
	
	public TwoTreeMirrorImage(T data) {
		this.root =  new TreeNode<T>(data);
	}
	
	private boolean isMirrorOf(TreeNode<T> root1, TreeNode<T> root2) {
		if(root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		} else if (root1.data != root2.data) {
			return false;
		} else {
			return (isMirrorOf(root1.left, root2.right) && (isMirrorOf(root1.right, root2.left)));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoTreeMirrorImage<Integer> tree1 = new TwoTreeMirrorImage<Integer>(1);
		if(tree1.root != null) {
			tree1.root.left = new TreeNode<Integer>(2);
			tree1.root.right = new TreeNode<Integer>(3);
			tree1.root.left.left = new TreeNode<Integer>(4);
			tree1.root.left.right = new TreeNode<Integer>(5);
			tree1.root.right.left = new TreeNode<Integer>(6);
			tree1.root.right.right = new TreeNode<Integer>(7);
		}
		
		TwoTreeMirrorImage<Integer> tree2 = new TwoTreeMirrorImage<Integer>(1);
		if(tree2.root != null) {
			tree2.root.left = new TreeNode<Integer>(3);
			tree2.root.right = new TreeNode<Integer>(2);
			tree2.root.left.left = new TreeNode<Integer>(7);
			tree2.root.left.right = new TreeNode<Integer>(6);
			tree2.root.right.left = new TreeNode<Integer>(5);
			tree2.root.right.right = new TreeNode<Integer>(4);
		}
		
		System.out.println("Are these trees identical ? "+tree1.isMirrorOf(tree1.root, tree2.root));
		
	}

}
