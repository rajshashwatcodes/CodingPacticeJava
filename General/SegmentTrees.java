class SegmentTree {
    private int[] tree;
    private int[] nums;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        int treeSize = 2 * (int) Math.pow(2, height) - 1;
        tree = new int[treeSize];
        buildSegmentTree(0, 0, n - 1);
    }

    private void buildSegmentTree(int index, int start, int end) {
        if (start == end) {
            tree[index] = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            buildSegmentTree(leftChildIndex, start, mid);
            buildSegmentTree(rightChildIndex, mid + 1, end);

            tree[index] = tree[leftChildIndex] + tree[rightChildIndex];
        }
    }

    public int query(int queryStart, int queryEnd) {
        return query(0, 0, nums.length - 1, queryStart, queryEnd);
    }

    private int query(int index, int start, int end, int queryStart, int queryEnd) {
        if (queryEnd < start || queryStart > end) {
            // The query range is outside the current segment
            return 0;
        } else if (queryStart <= start && queryEnd >= end) {
            // The query range is completely inside the current segment
            return tree[index];
        } else {
            // Partial overlap, so we need to look into both left and right segments
            int mid = start + (end - start) / 2;
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            int leftSum = query(leftChildIndex, start, mid, queryStart, queryEnd);
            int rightSum = query(rightChildIndex, mid + 1, end, queryStart, queryEnd);

            return leftSum + rightSum;
        }
    }

    public void update(int i, int val) {
        update(0, 0, nums.length - 1, i, val);
    }

    private void update(int index, int start, int end, int i, int val) {
        if (start == end) {
            // Leaf node, update the value
            nums[i] = val;
            tree[index] = val;
        } else {
            int mid = start + (end - start) / 2;
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            if (i <= mid) {
                // Update in the left sub-tree
                update(leftChildIndex, start, mid, i, val);
            } else {
                // Update in the right sub-tree
                update(rightChildIndex, mid + 1, end, i, val);
            }

            // Update the current node after updating the child nodes
            tree[index] = tree[leftChildIndex] + tree[rightChildIndex];
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(nums);

        // Query the sum of elements in the range [1, 4]
        System.out.println("Sum in range [1, 4]: " + segmentTree.query(1, 4));

        // Update the value at index 2 to 6
        segmentTree.update(2, 6);

        // Query the sum of elements in the range [1, 4] after the update
        System.out.println("Sum in range [1, 4] after update: " + segmentTree.query(1, 4));
    }
}
