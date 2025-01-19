//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 深度优先搜索 数组 字符串 回溯 矩阵 👍 1919 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[][] step = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0},};

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] flag = new boolean[rows][cols];
        var data = word.toCharArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, flag, i, j, rows, cols, data, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] flag, int i, int j, int rows, int cols, char[] data, int dataIndex) {
        if (dataIndex >= data.length) {
            return true;
        }

        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            return false;
        }

        if (flag[i][j]) {
            return false;
        }
        char target = data[dataIndex];
        if (board[i][j] != target) {
            return false;
        }

        flag[i][j] = true;


        for (int[] offset : step) {
            int x = i + offset[0];
            int y = j + offset[1];
            if (dfs(board, flag, x, y, rows, cols, data, dataIndex + 1)) {
                return true;
            }
        }

        flag[i][j] = false;
        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
