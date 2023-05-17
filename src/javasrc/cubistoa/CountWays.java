/*
 * @Created 05/17/2023 - 12:17 PM
 * @Author sun
 * @Info: Q6313
 */
package javasrc.cubistoa;

public class CountWays {
    public static int countWays(int[][] ranges) {
        boolean[] merged = new boolean[ranges.length];
        int num = 0;

        int res;
        int start;
        for(res = 0; res < ranges.length && !merged[res]; ++res) {
            merged[res] = true;
            start = ranges[res][0];
            int end = ranges[res][1];

            for(int j = 0; j < ranges.length && !merged[j]; ++j) {
                if (ranges[j][0] >= start && ranges[j][0] <= end || ranges[j][1] >= start && ranges[j][1] <= end || start <= ranges[j][0] && end >= ranges[j][1] || start >= ranges[j][0] && end <= ranges[j][1]) {
                    merged[j] = true;
                    start = Math.min(start, ranges[j][0]);
                    end = Math.max(end, ranges[j][1]);
                }
            }

            ++num;
        }

        res = 0;

        for(start = 0; start <= num; ++start) {
            res = (int)((long)res + cal(num, start));
        }

        res %= 1000000007;
        return res;
    }

    public static long cal(int total, int pick) {
        if (pick == 0) {
            return 1L;
        } else if (pick > total - pick) {
            return cal(total, total - pick);
        } else {
            int dividend = 1;
            int divisor = 1;

            for(int i = 0; i < pick; ++i) {
                dividend *= total - i;
                divisor *= i + 1;
            }

            return (long)(dividend / divisor);
        }
    }
}
