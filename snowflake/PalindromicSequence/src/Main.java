/*
 * @Created ${MONTH}/${DAY}/${YEAR} - ${TIME}
 * @Author ${USER}
 *
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int x = s.palindromicSequence("acdapmpomp");
        System.out.println(x);
    }

}

class Solution {

    static int maxScore = 0;
    public int palindromicSequence(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                //Fill dp[j][j+i]
                if (i == 0) dp[j][j + i] = 1;
//                else if (i == 1) {
//                    if (s.charAt(i) == s.charAt(i + j)) {
//                        dp[i][j + i] = 2;
//                    } else {
//                        dp[i][j + i] = 1;
//                    }
                else {
                    if (s.charAt(j) == s.charAt(j + i)) {
                        dp[j][j + i] = dp[j + 1][j + i - 1] + 2;
                    } else {
                        dp[j][j + i] = Math.max(dp[j][j + i - 1], dp[j + 1][j + i]);
                    }
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }

        backtracking(dp, 0, s.length(), 1);

        return maxScore;
    }

    public void backtracking(int[][] dp, int start, int len, int currScore) {
        if (start == len) {
//            System.out.println(currScore);
            if (currScore > maxScore) maxScore = currScore;
            return;
        }
        for (int i = 0; i < len-start; i++) {
            currScore = currScore * dp[start][start+i];
            backtracking(dp, start+i+1, len, currScore);
            currScore = currScore/dp[start][start+i];
        }
    }
}