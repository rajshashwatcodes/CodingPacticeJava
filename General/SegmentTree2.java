public class SegmentTree {
    int[] st;

    public SegmentTree(int[] arr, int n) {
        st = new int[4 * n];
        build(arr, 0, n - 1, 0);
    }

    private void build(int[] arr, int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return;
        }
        int mid = ss + (se - ss) / 2;
        build(arr, ss, mid, 2 * si + 1);
        build(arr, mid + 1, se, 2 * si + 2);
        st[si] = st[2 * si + 1] + st[2 * si + 2];
    }

    public int sumRange(int qs, int qe, int n) {
        return sumRangeUtil(0, n - 1, qs, qe, 0);
    }

    private int sumRangeUtil(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se)
            return st[si];
        if (se < qs || ss > qe)
            return 0;
        int mid = ss + (se - ss) / 2;
        return sumRangeUtil(ss, mid, qs, qe, 2 * si + 1) +
               sumRangeUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        SegmentTree tree = new SegmentTree(arr, n);
        System.out.println("Sum of values in given range = " +
                           tree.sumRange(1, 3, n));
    }
}
