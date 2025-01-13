//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。 
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层（从第 0 层开始），则该层包含 1~ 2ʰ 个节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 10⁴] 
// 0 <= Node.val <= 5 * 10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
//
// Related Topics 位运算 树 二分查找 二叉树 👍 1208 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        var h = 0;
        TreeNode cur = root;
        while (cur.left != null) {
            h++;
            cur = cur.left;
        }

        int min = (1 << h);
        int max = (1 << (h + 1)) - 1;

        int ans = min;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (checkNodeExisted(mid, root, h)) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return ans;
    }

    private boolean checkNodeExisted(int mid, TreeNode root, int h) {
        int lastLevelLeaf = mid - (1 << h) + 1;
        int sub = 1 << (h - 1);
        while (sub > 0) {
            if (lastLevelLeaf > sub) {
                if (root.right == null) {
                    return false;
                }
                lastLevelLeaf -= sub;
                root = root.right;
            } else {
                if (root.left == null) {
                    return false;
                }
                root = root.left;
            }

            sub = (sub >> 1);
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));

//        System.out.println(new Solution().checkNodeExisted(4, root, 2));
//        System.out.println(new Solution().checkNodeExisted(5, root, 2));
//        System.out.println(new Solution().checkNodeExisted(6, root, 2));
//        System.out.println(!new Solution().checkNodeExisted(7, root, 2));


        System.out.println(new Solution().countNodes(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
