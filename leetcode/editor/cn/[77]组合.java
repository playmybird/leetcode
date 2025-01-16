//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1716 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> stack = new ArrayList<>(k);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(1, n, k, stack, ans);
        return ans;
    }

    private void dfs(int start, int end, int k, List<Integer> stack, List<List<Integer>> ans){
        if (end-start+1<k){
            return;
        }

        k--;
        for (int i = start; i <= end; i++) {
            stack.add(i);
            if (k==0){
                ans.add(new ArrayList<>(stack));
                stack.removeLast();
                continue;
            }

            dfs(i+1, end, k, stack, ans);
            stack.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
