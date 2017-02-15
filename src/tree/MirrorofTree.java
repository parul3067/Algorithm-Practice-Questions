package tree;

public class MirrorofTree<T> {
	
	TreeNode<T> root;
	
	public MirrorofTree() {
		this.root = null;
	}
	
	public MirrorofTree(T data) {
		this.root =  new TreeNode<T>(data);
	}
	
	private void preOrder(TreeNode<T> root) {
		if(root == null) {
			return;
		} else {
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	private TreeNode<T> mirror(TreeNode<T> root) {
		TreeNode<T> temp,left,right;
		
 		if(root == null) {
			return null;
		} else {
			left = mirror(root.left);
			right = mirror(root.right);
			
			temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
 		
 		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MirrorofTree<Integer> tree = new MirrorofTree<Integer>(1);
		if(tree.root != null) {
			tree.root.left = new TreeNode<Integer>(2);
			tree.root.right = new TreeNode<Integer>(3);
			tree.root.left.left = new TreeNode<Integer>(4);
			tree.root.left.right = new TreeNode<Integer>(5);
			tree.root.right.left = new TreeNode<Integer>(6);
			tree.root.right.right = new TreeNode<Integer>(7);
		}
		
		tree.preOrder(tree.root);
		TreeNode<Integer> newNode = tree.mirror(tree.root);
		System.out.println("\nAfter mirroring");
		tree.preOrder(newNode);

	}
}
