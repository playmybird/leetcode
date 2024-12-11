//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1807 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] step = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];

        int visitNum = 0;
        int d = 0;
        int x = 0;
        int y = 0;
        while (visitNum < rows * cols) {
            visited[x][y] = true;
            visitNum++;
            ans.add(matrix[x][y]);

            // find next
            int nextX = step[d][0] + x;
            int nextY = step[d][1] + y;
            if (!checkPoint(visited, nextX, nextY)) {
                d++;
                if (d >= step.length) {
                    d = 0;
                }

                nextX = step[d][0] + x;
                nextY = step[d][1] + y;
                if (!checkPoint(visited, nextX, nextY)) {
                    break;
                }
            }

            x = nextX;
            y = nextY;
        }
        return ans;
    }

    private boolean checkPoint(boolean[][] visited, int x, int y) {
        if (x >= visited.length || x < 0) {
            return false;
        } else if (y >= visited[0].length || y < 0) {
            return false;
        }
        return !visited[x][y];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
