class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        
        if (root.val > L) {
            sum += rangeSumBST(root.left, L, R);
        }
        
        if (root.val < R) {
            sum += rangeSumBST(root.right, L, R);
        }
        
        return sum;
    }

    public static void main(String[] args) {
        RangeSumBST solution = new RangeSumBST();

        // Construct the BST
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(20);

        int L = 5;
        int R = 11;

        int result = solution.rangeSumBST(root, L, R);
        System.out.println("Sum of values in the range [" + L + ", " + R + "]: " + result); // Output: 11
    }
}
