package leetcode;

public class Sqrt69 {
    public static void main(String[] args) {
        Sqrt69 s = new Sqrt69();
        int v = s.mySqrt(Integer.MAX_VALUE);
        System.out.println(Integer.toHexString(v));

    }

    public int mySqrt(int x) {
        int lo = 0;
        int hi = x;

        while (lo < hi) {
            int mid = (lo + hi + 1) >>>1;
            if (mid > x / mid) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return hi;
    }
}