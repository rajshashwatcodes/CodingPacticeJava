class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class PreorderToBinaryTree {
    private int index = 0;

    public TreeNode buildTree(int[] preorder) {
        return buildTree(preorder, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[] preorder, int bound) {
        if (index >= preorder.length || preorder[index] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index]);
        index++;

        root.left = buildTree(preorder, root.val);
        root.right = buildTree(preorder, bound);

        return root;
    }

    // Utility function to perform an inorder traversal for testing
    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        PreorderToBinaryTree builder = new PreorderToBinaryTree();
        TreeNode root = builder.buildTree(preorder);

        System.out.println("Inorder Traversal of the Built Tree:");
        builder.inorderTraversal(root);
    }
}
