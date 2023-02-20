package leetcode;

import java.util.*;

public class CheapestFlightsWithinKStops787 {
    public static void main(String[] args) {
        CheapestFlightsWithinKStops787 s = new CheapestFlightsWithinKStops787();
        /*n =
3
flights =
[[0,1,100],[1,2,100],[0,2,500]]*/
        s.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> src2Targets = new HashMap();
        for (int[] flight : flights) {
            src2Targets.computeIfAbsent(flight[0], v -> new ArrayList<>())
                    .add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.offer(new int[]{src, 0});
        int stop = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int src1 = curr[0];
                if (src1 == dst) return curr[1];
                if (!src2Targets.containsKey(src1)) continue;
                for (int[] target : src2Targets.get(src1)) {
                    q.offer(new int[]{target[0], target[1] + curr[1]});
                }
            }
            if (stop > k) break;
            stop++;
        }
        return -1;
    }
}