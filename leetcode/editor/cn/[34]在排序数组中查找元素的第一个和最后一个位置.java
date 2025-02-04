//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2884 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int l = searchLeftEqualOrLargeThan(nums, target, 0);
        if (nums[l] != target) {
            return new int[]{-1, -1};
        }

        int r = searchLeftEqualOrLargeThan(nums, target + 1, l);
        if (nums[r] != target) {
            r--;
        }
        return new int[]{l, r};
    }

    private int searchLeftEqualOrLargeThan(int[] nums, int target, int start) {
        int l = start;
        if (target < nums[l]) {
            return l;
        }

        int r = nums.length - 1;
        if (nums[r] < target) {
            return nums.length - 1;
        }

        while (l < r) {
            int mid = (l + r) / 2;
            int cur = nums[mid];
            if (target <= cur) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 7, 8, 8, 10}, 6)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
