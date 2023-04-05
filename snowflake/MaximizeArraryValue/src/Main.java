import java.util.Arrays;

/*
 * @Created ${MONTH}/${DAY}/${YEAR} - ${TIME}
 * @Author ${USER}
 *
 */
public class Main {
    public static void main(String[] args) {


        int[] input = new int[]{1, 5, 7, 6};
        int[] input2 = new int[] {7, 6, 5, 1};

        Solution s = new Solution();
        int x = s.maxArrayValue(4, input2);

        System.out.println(x);
    }
}

class Solution {

    static int[] sum;

    static int[] supplement;

    public int maxArrayValue(int n, int[] nums) {
        sum = new int[n];
        supplement = new int[n];
        Arrays.fill(supplement, 0);
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        return helper(n, nums);
    }

    public int helper(int n, int[] nums) {
        if (n == 1) return sum[0] + supplement[0];

        int avg = (sum[n-1] + supplement[n-1]) / n;
        if (nums[n-1] < avg) {
            supplement[n-2] = supplement[n-1];
            return helper(n-1, nums);
        } else {
            supplement[n-2] = nums[n-1] - (int) Math.ceil(avg) + supplement[n-1];
        }

        return helper(n-1, nums);
    }
}