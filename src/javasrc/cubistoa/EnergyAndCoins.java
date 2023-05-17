package javasrc.cubistoa;

/*
 * @Created 05/17/2023
 * @Author sun
 * @Info:
 */
public class EnergyAndCoins {
    public static void main(String[] args) {
        int n1 = 0;
        int[] energy1 = { 2, 1, 1 }, coins1 = { 11, 5, 7 };
        int n2 = 1;
        int[] energy2 = { 1, 5, 3, 3, 1 }, coins2 = { 3, 23, 9, 2, 2 };
        System.out.println(solve(n1, energy1, coins1));
        System.out.println(solve(n2, energy2, coins2));
    }

    private static int solve(int init, int[] energy, int[] coins) {
        int eSum = 0;
        for(int e : energy) {
            eSum += e;
        }
        int[][] dp = new int[coins.length][eSum + 1];
        for(int i=dp.length - 1;i>=0;i--) {
            for(int j=0;j<=coins.length;j++) {
                if(i == dp.length - 1) {
                    dp[i][j] = coins[i];
                    continue;
                }
                int take_energy = dp[i + 1][j + energy[i] - 1];
                if(j > 0) {
                    dp[i][j] = Math.max(take_energy, coins[i] + dp[i+1][j-1]);
                }else if(j == 0) {
                    dp[i][j] = Math.max(take_energy, coins[i]);
                }
            }
        }
        return dp[0][Math.min(dp[0].length, init)];
    }

}
