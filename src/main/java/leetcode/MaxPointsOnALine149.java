package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine149 {

    public static void main(String[] args) {
        MaxPointsOnALine149 s = new MaxPointsOnALine149();
        System.out.println(s.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    }

    public int maxPoints(int[][] points) {
        int ans = 2;
        for (int i = 0; i < points.length - 1; i++) {
            Map<Double, Integer> t2Cnt = new HashMap();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int[] p1 = points[i];
                int[] p2 = points[j];
                double tangent = Math.atan2(Math.abs(p2[1] - p1[1]), Math.abs(p2[0] - p1[0]));
                t2Cnt.put(tangent, t2Cnt.getOrDefault(tangent, 1) + 1);
                ans = Math.max(ans, t2Cnt.get(tangent));
            }
        }
        return ans;
    }
}