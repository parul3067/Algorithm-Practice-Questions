package tree;

public class IdenticalTrees<T> {
	
	TreeNode<T> root;
	boolean isIdentical = true;
	
	public IdenticalTrees() {
		this.root = null;
	}
	
	public IdenticalTrees(T root) {
		this.root = new TreeNode<T>(root);
	}
	
	private boolean isIdentical(TreeNode<T> root1, TreeNode<T> root2) {
		
		if(root1 != null && root2 != null) {
			if(root1.data != root2.data) {
				System.out.println("Enter not equals : root1 :"+root1.data+" root2 :"+root2.data);
				isIdentical = false;
				return isIdentical;
			} else {
				System.out.println("root1 :"+root1.data+" root2 :"+root2.data);
				isIdentical(root1.left,root2.left);
				isIdentical(root1.right,root2.right);
			}
		}
		
		return isIdentical;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IdenticalTrees<Character> tree1 = new IdenticalTrees<Character>('a');
		if(tree1.root != null) {
			tree1.root.left = new TreeNode<Character>('b');
			tree1.root.right = new TreeNode<Character>('c');
			tree1.root.left.left = new TreeNode<Character>('d');
			tree1.root.left.right = new TreeNode<Character>('e');
			tree1.root.right.left = new TreeNode<Character>('f');
			tree1.root.right.right = new TreeNode<Character>('g');
		}
		
		IdenticalTrees<Character> tree2 = new IdenticalTrees<Character>('a');
		if(tree2.root != null) {
			tree2.root.left = new TreeNode<Character>('b');
			tree2.root.right = new TreeNode<Character>('c');
			tree2.root.left.left = new TreeNode<Character>('d');
			tree2.root.left.right = new TreeNode<Character>('e');
			tree2.root.right.left = new TreeNode<Character>('f');
			tree2.root.right.right = new TreeNode<Character>('g');
		}
		
		System.out.println("Are both trees identical :"+tree1.isIdentical(tree1.root, tree2.root));
	}
}
