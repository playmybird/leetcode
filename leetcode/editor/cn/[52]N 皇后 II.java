//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 回溯 👍 559 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int ans = 0;
    private boolean[] cols;
    private boolean[] leftDown;
    private boolean[] rightDown;

    public int totalNQueens(int n) {
        cols = new boolean[n];
        leftDown = new boolean[n * 2 - 1];
        rightDown = new boolean[n * 2 - 1];
        dfs(0, n);
        return ans;
    }

    private void dfs(int startRow, int n) {
        if (startRow == n) {
            ans++;
            return;
        }

        // try every col
        for (int colIndex = 0; colIndex < n; colIndex++) {
            int leftDownIndex = startRow + colIndex;
            int rightDownIndex = startRow - colIndex + n - 1;
            if (!cols[colIndex] && !leftDown[leftDownIndex] && !rightDown[rightDownIndex]) {
                cols[colIndex] = leftDown[leftDownIndex] = rightDown[rightDownIndex] = true;
                dfs(startRow + 1, n);
                cols[colIndex] = leftDown[leftDownIndex] = rightDown[rightDownIndex] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
