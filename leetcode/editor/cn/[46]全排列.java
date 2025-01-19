//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 3014 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(new ArrayList<>(Arrays.stream(nums).boxed().toList()), new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(List<Integer> lastNumberList, ArrayList<Integer> stack, List<List<Integer>> ans) {
        if (lastNumberList.isEmpty()) {
            ans.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < lastNumberList.size(); i++) {
            stack.addLast(lastNumberList.remove(i));
            dfs(lastNumberList, stack, ans);
            lastNumberList.add(i, stack.removeLast());
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }
}

//leetcode submit region end(Prohibit modification and deletion)
