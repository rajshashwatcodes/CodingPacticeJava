class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    // Helper class to store the height and diameter information
    static class HeightAndDiameter {
        int height;
        int diameter;

        public HeightAndDiameter(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    // Function to calculate the diameter of the binary tree
    public int diameter(TreeNode root) {
        HeightAndDiameter result = findDiameter(root);
        return result.diameter;
    }

    // Helper function to recursively calculate height and diameter
    private HeightAndDiameter findDiameter(TreeNode node) {
        if (node == null) {
            return new HeightAndDiameter(0, 0);
        }

        // Recursively get the height and diameter of left and right subtrees
        HeightAndDiameter left = findDiameter(node.left);
        HeightAndDiameter right = findDiameter(node.right);

        // Calculate height
        int height = 1 + Math.max(left.height, right.height);

        // Calculate diameter considering three cases: diameter through the root,
        // diameter in the left subtree, and diameter in the right subtree
        int diameterThroughRoot = left.height + right.height;
        int maxDiameterSoFar = Math.max(diameterThroughRoot, Math.max(left.diameter, right.diameter));

        return new HeightAndDiameter(height, maxDiameterSoFar);
    }
}

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Constructing a sample binary tree
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        // Calculate and print the diameter of the binary tree
        int treeDiameter = tree.diameter(tree.root);
        System.out.println("Diameter of the binary tree: " + treeDiameter);
    }
}
