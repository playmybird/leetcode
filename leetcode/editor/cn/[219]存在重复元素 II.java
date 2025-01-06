//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i 
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 748 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }

        var valueSet = new HashSet<Integer>(k + 1);
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (i > k) {
                valueSet.remove(nums[i - k - 1]);
            }
            if (valueSet.contains(v)) {
                return true;
            }
            valueSet.add(v);
        }

        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
