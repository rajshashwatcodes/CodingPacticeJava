class SegmentTree {
    int[] segmentTree;
    int[] nums;
    int n;
    
    public SegmentTree(int[] nums) {
        this.nums = nums;
        n = nums.length;
        int height = (int)Math.ceil(Math.log(n) / Math.log(2));
        int maxSize = 2 * (int)Math.pow(2, height) - 1;
        segmentTree = new int[maxSize];
        buildTree(0, 0, n - 1);
    }
    
    private void buildTree(int index, int start, int end) {
        if (start == end) {
            segmentTree[index] = nums[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildTree(2 * index + 1, start, mid);
        buildTree(2 * index + 2, mid + 1, end);
        segmentTree[index] = Math.min(segmentTree[2 * index + 1], segmentTree[2 * index + 2]);
    }
    
    public int query(int start, int end) {
        return queryHelper(0, 0, n - 1, start, end);
    }
    
    private int queryHelper(int index, int segStart, int segEnd, int qStart, int qEnd) {
        if (qStart <= segStart && qEnd >= segEnd) {
            return segmentTree[index];
        }
        if (qEnd < segStart || qStart > segEnd) {
            return Integer.MAX_VALUE; // Outside the range
        }
        int mid = segStart + (segEnd - segStart) / 2;
        int left = queryHelper(2 * index + 1, segStart, mid, qStart, qEnd);
        int right = queryHelper(2 * index + 2, mid + 1, segEnd, qStart, qEnd);
        return Math.min(left, right);
    }
    
    public void update(int index, int newValue) {
        updateHelper(0, 0, n - 1, index, newValue);
    }
    
    private void updateHelper(int segIndex, int segStart, int segEnd, int index, int newValue) {
        if (segStart == segEnd) {
            nums[index] = newValue;
            segmentTree[segIndex] = newValue;
            return;
        }
        int mid = segStart + (segEnd - segStart) / 2;
        if (index <= mid) {
            updateHelper(2 * segIndex + 1, segStart, mid, index, newValue);
        } else {
            updateHelper(2 * segIndex + 2, mid + 1, segEnd, index, newValue);
        }
        segmentTree[segIndex] = Math.min(segmentTree[2 * segIndex + 1], segmentTree[2 * segIndex + 2]);
    }
}

public class SegmentTreeQueryUpdate {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 7, 9, 11};
        SegmentTree st = new SegmentTree(nums);
        System.out.println(st.query(1, 3)); // Output: 2
        st.update(2, 5);
        System.out.println(st.query(1, 3)); // Output: 3
    }
}
