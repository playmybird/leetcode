//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7368 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Index {
        int[] num1;
        int p1;

        public Index(int[] num1, int[] num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        int[] num2;
        int p2;


        public int next() {
            int ans = 0;
            if (num1.length == p1) {
                ans = num2[p2];
                p2++;
            } else if (num2.length == p2) {
                ans = num1[p1];
                p1++;
            } else if (num1[p1] < num2[p2]) {
                ans = num1[p1];
                p1++;
            } else {
                ans = num2[p2];
                p2++;
            }
            return ans;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = nums1.length + nums2.length;
        int move = (count - 1) / 2;
        Index index = new Index(nums1, nums2);
        while (move > 0) {
            move--;
            index.next();
        }

        double ans = index.next();
        if (count % 2 == 0) {
            ans += index.next();
            ans /= 2;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
