//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
//
// Related Topics 数组 数学 矩阵 👍 1967 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[][] step = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
    };

    public void rotate(int[][] matrix) {
        int n = matrix.length/2;
        for (int circle = 0; circle < n; circle++) {
            int[][]startPoint = getFourStartPoint(matrix, circle);
            for (int walk = 0; hesNext(matrix, circle, walk); walk++) {
                walk(matrix, walk, startPoint);
            }
        }
    }

    private int[][] getFourStartPoint(int[][] matrix, int circle) {
        int n = matrix.length;
        return new int[][]{
                {circle, circle},
                {circle, n - 1 - circle},
                {n - 1 - circle, n - 1 - circle},
                {n - 1 - circle, circle}
        };
    }

    private boolean hesNext(int[][] matrix, int circle, int walk) {
        int n = matrix.length;
        return circle + walk < n - 1 - circle;
    }

    private void walk(int[][] matrix, int walk, int[][]startPoint){
        // read
        int[]point4 = new int[step.length];
        for (int i = 0; i < step.length; i++) {
            point4[i] = matrix[startPoint[i][0]+walk*step[i][0]][startPoint[i][1]+walk*step[i][1]];
        }

        // move right ring
        int last = point4[step.length-1];
        for (int i = step.length - 1; i - 1>=0; i--) {
            point4[i] = point4[i-1];
        }
        point4[0] = last;

        // write
        for (int i = 0; i < step.length; i++) {
            matrix[startPoint[i][0]+walk*step[i][0]][startPoint[i][1]+walk*step[i][1]]=point4[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
