package javasrc.cubistoa;
/*
 * @Created 05/17/2023 - 12:18 PM
 * @Author sun
 *
 */

import java.util.HashMap;
import java.util.Map;

public class TaskScheduling {
    class Solution {
        private final long INF = 922337203685477580L;

        Solution() {
        }

        public long getMinCost(int[] cost, int[] time) {
            assert cost.length > 0;

            assert cost.length == time.length;

            Map<Integer, Long>[] memo = new Map[cost.length];

            for(int i = 0; i < cost.length; ++i) {
                memo[i] = new HashMap();
            }

            return this.dfs(0, cost, 0, time, memo);
        }

        private long dfs(int i, int[] cost, int timeSoFar, int[] time, Map<Integer, Long>[] memo) {
            System.out.println("traversing: i = " + i + "timeSoFar = " + timeSoFar);
            int n = cost.length;
            if (i == n) {
                return timeSoFar >= 0 ? 0L : 922337203685477580L;
            } else if (timeSoFar >= n - i) {
                return 0L;
            } else if (memo[i].containsKey(timeSoFar)) {
                return (Long)memo[i].get(timeSoFar);
            } else {
                long resPaid = (long)cost[i] + this.dfs(i + 1, cost, timeSoFar + time[i], time, memo);
                System.out.println("resPaid " + resPaid);
                long resFree = this.dfs(i + 1, cost, timeSoFar - 1, time, memo);
                System.out.println("resFree " + resFree);
                memo[i].put(timeSoFar, Math.min(resPaid, resFree));
                System.out.println("memo[" + i + "].get(" + timeSoFar + ") = " + memo[i].get(timeSoFar));
                return (Long)memo[i].get(timeSoFar);
            }
        }
    }
}
