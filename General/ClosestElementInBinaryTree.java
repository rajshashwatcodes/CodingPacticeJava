class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class ClosestElementInBinaryTree {

    private int closestValue;

    // Function to find the closest element in a binary tree
    public int closestElement(TreeNode root, double target) {
        closestValue = root.val;
        findClosestElement(root, target);
        return closestValue;
    }

    private void findClosestElement(TreeNode root, double target) {
        if (root == null) {
            return;
        }

        if (Math.abs(root.val - target) < Math.abs(closestValue - target)) {
            closestValue = root.val;
        }

        if (target < root.val) {
            findClosestElement(root.left, target);
        } else {
            findClosestElement(root.right, target);
        }
    }

    public static void main(String[] args) {
        ClosestElementInBinaryTree finder = new ClosestElementInBinaryTree();

        // Example Binary Search Tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        double target = 3.714;

        int closestElement = finder.closestElement(root, target);
        System.out.println("Closest element to " + target + " is: " + closestElement);
    }
}
