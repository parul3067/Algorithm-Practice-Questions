package tree;

public class RootToLeafEqualSum {
	Node root;
	
	
	public RootToLeafEqualSum() {
		this.root = null;
	}
	
	public RootToLeafEqualSum(int data) {
		this.root =  new Node(data);
	}
	
	private boolean hasPathWithSum(Node root, int num) {
		if(root == null) {
			return false;
		} else {
			if(root.left == null && root.right == null && root.data == num) {
				return true;
			} else {
				boolean ans = false;
				ans = ans || hasPathWithSum(root.left, num - root.data);
				ans = ans || hasPathWithSum(root.right, num - root.data);
				
				return ans;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RootToLeafEqualSum tree = new RootToLeafEqualSum(10);
		tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
        
        int sum = 23;
        if(tree.hasPathWithSum(tree.root, sum)) {
        	System.out.println("Yes");
        } else {
        	System.out.println("No");
        }
	}
}
