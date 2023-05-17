package javasrc.contest.biweekly99;

/*
 * @Created 05/17/2023
 * @Author sun
 * @Info: https://leetcode.com/contest/biweekly-contest-99/problems/count-ways-to-group-overlapping-ranges/
 */
public class GroupOverlappingRanges {
    public static void main(String[] args) {
        int[][] test = new int[8][];
        test[0] = new int[]{34,56};
        test[1] = new int[]{28,29};
        test[2] = new int[]{12,16};
        test[3] = new int[]{11,48};
        test[4] = new int[]{28,54};
        test[5] = new int[]{22,55};
        test[6] = new int[]{28,41};
        test[7] = new int[]{41,44};
        System.out.println(countWays(test));
    }


    public static int countWays(int[][] ranges) {
        boolean[] merged = new boolean[ranges.length];
        int num = 0;
        for (int i = 0; i < ranges.length && !merged[i]; i++) {
            merged[i] = true;
            int start = ranges[i][0];
            int end = ranges[i][1];
            for (int j = 0; j < ranges.length && !merged[j]; j++) {
                if ((ranges[j][0] >= start && ranges[j][0] <= end)
                        || (ranges[j][1] >= start && ranges[j][1] <= end)
                        || (start<= ranges[j][0] && end >= ranges[j][1])
                        || (start>= ranges[j][0] && end <= ranges[j][1])) {
                    merged[j] = true;
                    start = Math.min(start, ranges[j][0]);
                    end = Math.max(end, ranges[j][1]);
                }
            }
            num ++;
        }
        int res = 0;
        for (int i = 0; i <= num; i++) {
            res += cal(num, i);
        }
        res = res % (1000000000 +7);
        return res;
    }

    public static long cal(int total, int pick) {
        if (pick == 0) return 1;
        if (pick > total-pick) return cal(total, total-pick);
        int dividend = 1;
        int divisor = 1;
        for (int i = 0; i < pick; i++) {
            dividend = dividend*(total-i);
            divisor = divisor*(i+1);
        }
        return dividend/divisor;
    }
}