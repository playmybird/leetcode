import java.util.Arrays;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length + 2;
        int[] dp = new int[n];
        Arrays.fill(dp, 2, dp.length - 1, Integer.MAX_VALUE);
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i - 2] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}