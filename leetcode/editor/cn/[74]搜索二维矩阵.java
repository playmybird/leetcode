//给你一个满足下述两条属性的 m x n 整数矩阵： 
//
// 
// 每行中的整数从左到右按非严格递增顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 1004 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0;
        int r = rows - 1;
        int ans = 0;
        while (l < r) {
            int mid = (l + r) / 2;
            int cur = matrix[mid][cols - 1];
            if (cur == target) {
                return true;
            } else if (target < cur) {
                r = mid;
                ans = r;
            } else {
                l = mid + 1;
                ans = l;
            }
        }

        rows = ans;
        l = 0;
        r = cols - 1;
        ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            int cur = matrix[rows][mid];
            if (cur == target) {
                return true;
            } else if (target < cur) {
                r = mid - 1;
                ans = r;
            } else {
                l = mid + 1;
                ans = l;
            }
        }

        if (ans < 0 || ans >= cols) {
            return false;
        }

        return matrix[rows][ans] == target;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 60));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
