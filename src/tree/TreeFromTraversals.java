package tree;

public class TreeFromTraversals<T> {
	char preOrder[] = {'A','B','D','E','C','F'};
	char inOrder[] = {'D','B','E','A','F','C'};
	int preOrderIndex = 0;
	TreeNode<Character> root;
	
	private TreeNode<Character> constructTree(int inStartIndex, int inEndIndex) {
		TreeNode<Character> root = new TreeNode<Character>(preOrder[preOrderIndex++]); 
		System.out.println("root data :"+root.data);
		if(inStartIndex == inEndIndex) {
			return root;
		} else {
			int inOrderIndex = 0;
			while(inOrder[inOrderIndex] != root.data) {
				inOrderIndex++;
			}
			//preOrderIndex++;
			if(preOrderIndex < preOrder.length)
				root.left = constructTree(inStartIndex,inOrderIndex - 1);
			
			if(preOrderIndex < preOrder.length)
				root.right = constructTree(inOrderIndex + 1, inEndIndex);
		}
		
		return root;
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
	
	private void inOrder(TreeNode<T> root) {
		if(root == null) {
			return;
		} else {
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeFromTraversals<Character> tree = new TreeFromTraversals<Character>();
		tree.root = tree.constructTree(0,tree.inOrder.length - 1);
		tree.inOrder(tree.root);
		System.out.println();
		tree.preOrder(tree.root);
	}

}
