//给你两个整数数组 nums1 和 nums2，它们的长度分别为 m 和 n。数组 nums1 和 nums2 分别代表两个数各位上的数字。同时你也会得到一个
//整数 k。 
//
// 请你利用这两个数组中的数字中创建一个长度为 k <= m + n 的最大数，在这个必须保留来自同一数组的数字的相对顺序。 
//
// 返回代表答案的长度为 k 的数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [3,4,6,5], nums2 = [9,1,2,5,8,3], k = 5
//输出：[9,8,6,5,3]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [6,7], nums2 = [6,0,4], k = 5
//输出：[6,7,6,0,4]
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [3,9], nums2 = [8,9], k = 3
//输出：[9,8,9]
// 
//
// 
//
// 提示： 
//
// 
// m == nums1.length 
// n == nums2.length 
// 1 <= m, n <= 500 
// 0 <= nums1[i], nums2[i] <= 9 
// 1 <= k <= m + n 
// 
//
// Related Topics 栈 贪心 数组 双指针 单调栈 👍 601 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {


    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        List<Integer> max = null;

        for (int p1 = 0; p1 <= k; p1++) {
            int p2 = k - p1;
            if (!(p1 <= nums1.length && p2 <= nums2.length)) {
                continue;
            }

            var ans1 = getMaxN(nums1, p1);
            var ans2 = getMaxN(nums2, p2);
            var ans = merge(ans1, ans2);
            if (max == null) {
                max = ans;
                continue;
            }

            if (compare(max, 0, ans, 0) < 0) {
                max = ans;
            }
        }

        assert max != null;
        return max.stream().mapToInt(i -> i).toArray();
    }

    public int compare(List<Integer> list1, int p1, List<Integer> list2, int p2) {
        for (int offset = 0; offset < Math.min(list1.size() - p1, list2.size() - p2); offset++) {
            int c1 = list1.get(p1 + offset);
            int c2 = list2.get(p2 + offset);
            if (c1 == c2) {
                continue;
            }
            return c1 - c2;
        }

        return list1.size() - p1 - (list2.size() - p2);
    }

    public List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        var ans = new ArrayList<Integer>(list1.size() + list2.size());
        int p1 = 0;
        int p2 = 0;
        while (p1 < list1.size() && p2 < list2.size()) {
            if (compare(list1, p1, list2, p2) > 0) {
                ans.add(list1.get(p1));
                p1++;
            } else {
                ans.add(list2.get(p2));
                p2++;
            }
        }

        if (p1 == list1.size()) {
            p1 = p2;
            list1 = list2;
        }

        while (p1 < list1.size()) {
            ans.add(list1.get(p1));
            p1++;
        }

        return ans;
    }

    public List<Integer> getMaxN(int[] num, int k) {
        List<Integer> ans = new ArrayList<>(k);
        if (k == 0) {
            return ans;
        }

        for (int i = 0; i < num.length; i++) {
            int c = num[i];
            if (ans.isEmpty()) {
                ans.add(c);
                continue;
            }

            if (ans.getLast() >= c) {
                if (ans.size() < k) {
                    ans.add(c);
                }
                continue;
            }

            while (!ans.isEmpty() && ans.getLast() < c && k - ans.size() < num.length - i) {
                ans.removeLast();
            }
            ans.add(c);
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
