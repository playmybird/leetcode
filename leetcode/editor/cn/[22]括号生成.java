//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3756 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> stack = new ArrayList<>(2 * n);
        List<String> ans = new ArrayList<>();
        dfs(ans, stack, n, 0);
        return ans;
    }

    private void dfs(List<String> ans, List<String> stack, int n, int rightCount) {
        if (n == 0 && rightCount == 0) {
            ans.add(stack.stream().reduce((s, s2) -> s + s2).get());
            return;
        }

        if (n > 0) {
            stack.addLast("(");
            dfs(ans, stack, n - 1, rightCount + 1);
            stack.removeLast();
        }

        if (rightCount > 0) {
            stack.addLast(")");
            dfs(ans, stack, n, rightCount - 1);
            stack.removeLast();
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
