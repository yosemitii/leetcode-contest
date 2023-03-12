import java.util.Arrays;

/*
 * @Created ${MONTH}/${DAY}/${YEAR} - ${TIME}
 * @Author ${USER}
 * https://leetcode.com/contest/weekly-contest-336/problems/rearrange-array-to-maximize-prefix-score/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        int[] prefix = new int[nums.length];
        int len = nums.length;
        prefix[0] = nums[len-1];
//        int prefix = nums[len-1];
        if (prefix[0] <= 0) return 0;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[len-1-i];
            if (prefix[i] <= 0) return cnt;
            cnt++;
        }
        return cnt;
    }
}