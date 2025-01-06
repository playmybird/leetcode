//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 7202 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = 0;
        List<List<Integer>> ans = new ArrayList<>();
        int zeroLeft = find(nums, 0, nums.length - 1, 0);
        if (nums[zeroLeft] == 0) {
            int zeroRight = find(nums, 0, nums.length - 1, 1);
            if (nums[zeroRight] == 0) {
                zeroRight++;
            }
            if (zeroRight - zeroLeft >= 3) {
                ans.add(new ArrayList<>(List.of(0, 0, 0)));
            }

            if (nums[0] == 0 || nums[nums.length - 1] == 0) {
                return ans;
            }

            l = zeroLeft - 1;
            r = zeroRight;
        } else {
            l = zeroLeft - 1;
            r = zeroLeft;
        }

        if (l < 0 || r >= nums.length) {
            return ans;
        }


        int flagR = r;
        while (l >= 0) {
            while (l - 1 >= 0 && nums[l - 1] == nums[l]) {
                l--;
            }

            r = flagR;

            while (r < nums.length) {
                while (r + 1 < nums.length && nums[r + 1] == nums[r]) {
                    r++;
                }

                int target = -(nums[l] + nums[r]);
                if (check(nums, l + 1, r - 1, target)) {
                    ans.add(new ArrayList<>(List.of(nums[l], nums[r], target)));
                }

                r++;
            }

            l--;
        }

        return ans;
    }

    private int find(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int l, int r, int target) {
        if (l > r) {
            return false;
        }
        return nums[find(nums, l, r, target)] == target;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-2, 1, 4}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
