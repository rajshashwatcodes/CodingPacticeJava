class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BalancedBSTConverter {

    // Function to convert a BST to a sorted array using in-order traversal
    private void inOrderTraversal(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left, nodes);
        nodes.add(root);
        inOrderTraversal(root.right, nodes);
    }

    // Function to build a balanced BST from a sorted array
    private TreeNode sortedArrayToBST(List<TreeNode> nodes, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = nodes.get(mid);

        root.left = sortedArrayToBST(nodes, start, mid - 1);
        root.right = sortedArrayToBST(nodes, mid + 1, end);

        return root;
    }

    // Function to convert a BST to a balanced BST
    public TreeNode convertBSTtoBalancedBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        inOrderTraversal(root, nodes);

        int n = nodes.size();
        return sortedArrayToBST(nodes, 0, n - 1);
    }

    // Function to print the in-order traversal of a tree
    private void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        BalancedBSTConverter converter = new BalancedBSTConverter();

        // Example usage:
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        System.out.println("Original In-order traversal:");
        converter.printInOrder(root);
        System.out.println();

        TreeNode balancedRoot = converter.convertBSTtoBalancedBST(root);

        System.out.println("Balanced In-order traversal:");
        converter.printInOrder(balancedRoot);
    }
}
