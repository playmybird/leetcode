//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2971 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//import java.util.Arrays;
//
//class Solution {
//    final int INVALID = Integer.MAX_VALUE;
//    int[] buffer;
//
//    public int coinChange(int[] coins, int amount) {
//        buffer = new int[amount + 2];
//        Arrays.fill(buffer, INVALID);
//        return dp(amount, coins);
//    }
//
//    private int dp(int n, int[] coins) {
//        if (n < 0) {
//            return -1;
//        } else if (n == 0) {
//            return 0;
//        }
//
//        if (buffer[n] != INVALID) {
//            return buffer[n];
//        }
//
//        int ans = INVALID;
//        for (var c : coins) {
//            int min = dp(n - c, coins);
//            if (min == -1) {
//                continue;
//            }
//
//            ans = Math.min(ans, min + 1);
//        }
//
//        buffer[n] = ans == INVALID ? -1 : ans;
//        return buffer[n];
//    }
//}

import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 2];
        Arrays.fill(dp, amount + 2);

        dp[0] = 0;
        for (int curAmount = 1; curAmount <= amount; curAmount++) {
            for (var c : coins) {
                if (curAmount - c < 0) {
                    continue;
                }

                dp[curAmount] = Math.min(dp[curAmount], 1 + dp[curAmount - c]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}

//leetcode submit region end(Prohibit modification and deletion)
