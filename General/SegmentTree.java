public class SegmentTree {
    int[] segmentTree;

    public SegmentTree(int[] nums) {
        int n = nums.length;
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        segmentTree = new int[maxSize];
        buildSegmentTree(nums, 0, n - 1, 0);
    }

    private int buildSegmentTree(int[] nums, int start, int end, int index) {
        if (start == end) {
            segmentTree[index] = nums[start];
            return nums[start];
        }

        int mid = start + (end - start) / 2;
        segmentTree[index] = buildSegmentTree(nums, start, mid, 2 * index + 1) +
                             buildSegmentTree(nums, mid + 1, end, 2 * index + 2);
        return segmentTree[index];
    }

    public int sumRange(int start, int end) {
        return sumRangeHelper(0, 0, segmentTree.length - 1, start, end);
    }

    private int sumRangeHelper(int index, int segStart, int segEnd, int queryStart, int queryEnd) {
        if (segStart >= queryStart && segEnd <= queryEnd) {
            return segmentTree[index];
        }

        if (segEnd < queryStart || segStart > queryEnd) {
            return 0;
        }

        int mid = segStart + (segEnd - segStart) / 2;
        return sumRangeHelper(2 * index + 1, segStart, mid, queryStart, queryEnd) +
               sumRangeHelper(2 * index + 2, mid + 1, segEnd, queryStart, queryEnd);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(nums);

        // Example range sum queries
        System.out.println("Sum of elements from index 1 to 3: " + st.sumRange(1, 3)); // Output: 15
        System.out.println("Sum of elements from index 2 to 5: " + st.sumRange(2, 5)); // Output: 32
    }
}
