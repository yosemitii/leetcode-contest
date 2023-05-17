package javasrc.contest.weekly336;

import java.util.Arrays;

/*
 * @Created 05/17/2023
 * @Author sun
 * @Info: Q2.
 */
public class NaxunuzePrefixScore {

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