class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class MergeBSTs {

    // Function to perform inorder traversal and store values in a list
    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    // Function to merge two sorted lists into one sorted list
    private List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }

    // Function to build a BST from a sorted list
    private TreeNode buildBST(List<Integer> sortedList, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(sortedList.get(mid));

        root.left = buildBST(sortedList, start, mid - 1);
        root.right = buildBST(sortedList, mid + 1, end);

        return root;
    }

    // Function to merge two BSTs
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorderTraversal(root1, list1);
        inorderTraversal(root2, list2);

        List<Integer> mergedList = mergeLists(list1, list2);

        return buildBST(mergedList, 0, mergedList.size() - 1);
    }

    // Example usage
    public static void main(String[] args) {
        MergeBSTs merger = new MergeBSTs();

        // Example BST 1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        // Example BST 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(6);

        // Merge BSTs
        TreeNode mergedRoot = merger.mergeTrees(root1, root2);

        // Print the inorder traversal of the merged BST
        System.out.println("Inorder Traversal of Merged BST:");
        printInorder(mergedRoot);
    }

    // Helper function to print the inorder traversal of a BST
    private static void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }
}
