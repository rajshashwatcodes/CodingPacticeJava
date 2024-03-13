public class MaxMinSegmentTree {
    int[] maxTree;
    int[] minTree;
    int[] nums;

    public MaxMinSegmentTree(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        maxTree = new int[maxSize];
        minTree = new int[maxSize];
        buildSegmentTree(0, 0, n - 1);
    }

    private void buildSegmentTree(int index, int start, int end) {
        if (start == end) {
            maxTree[index] = nums[start];
            minTree[index] = nums[start];
            return;
        }

        int mid = start + (end - start) / 2;
        buildSegmentTree(2 * index + 1, start, mid);
        buildSegmentTree(2 * index + 2, mid + 1, end);
        maxTree[index] = Math.max(maxTree[2 * index + 1], maxTree[2 * index + 2]);
        minTree[index] = Math.min(minTree[2 * index + 1], minTree[2 * index + 2]);
    }

    public int rangeMaxQuery(int start, int end) {
        return rangeMaxQueryHelper(0, 0, nums.length - 1, start, end);
    }

    private int rangeMaxQueryHelper(int index, int segStart, int segEnd, int queryStart, int queryEnd) {
        if (segStart >= queryStart && segEnd <= queryEnd) {
            return maxTree[index];
        }

        if (segEnd < queryStart || segStart > queryEnd) {
            return Integer.MIN_VALUE;
        }

        int mid = segStart + (segEnd - segStart) / 2;
        return Math.max(rangeMaxQueryHelper(2 * index + 1, segStart, mid, queryStart, queryEnd),
                        rangeMaxQueryHelper(2 * index + 2, mid + 1, segEnd, queryStart, queryEnd));
    }

    public int rangeMinQuery(int start, int end) {
        return rangeMinQueryHelper(0, 0, nums.length - 1, start, end);
    }

    private int rangeMinQueryHelper(int index, int segStart, int segEnd, int queryStart, int queryEnd) {
        if (segStart >= queryStart && segEnd <= queryEnd) {
            return minTree[index];
        }

        if (segEnd < queryStart || segStart > queryEnd) {
            return Integer.MAX_VALUE;
        }

        int mid = segStart + (segEnd - segStart) / 2;
        return Math.min(rangeMinQueryHelper(2 * index + 1, segStart, mid, queryStart, queryEnd),
                        rangeMinQueryHelper(2 * index + 2, mid + 1, segEnd, queryStart, queryEnd));
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        MaxMinSegmentTree tree = new MaxMinSegmentTree(nums);

        // Example range maximum query
        int max = tree.rangeMaxQuery(1, 4);
        System.out.println("Maximum in range [1, 4]: " + max); // Output: 9

        // Example range minimum query
        int min = tree.rangeMinQuery(2, 5);
        System.out.println("Minimum in range [2, 5]: " + min); // Output: 7
    }
}
