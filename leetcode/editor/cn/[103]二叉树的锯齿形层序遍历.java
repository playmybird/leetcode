//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 942 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        List<TreeNode> cur = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        cur.add(root);
        ans.add(new ArrayList<>(List.of(root.val)));

        boolean toLeft = false;
        while (!cur.isEmpty()) {
            var c = cur.removeLast();
            if (toLeft) {
                if (c.left != null) {
                    next.add(c.left);
                }
                if (c.right != null) {
                    next.add(c.right);
                }
            } else {
                if (c.right != null) {
                    next.add(c.right);
                }
                if (c.left != null) {
                    next.add(c.left);
                }
            }

            if (cur.isEmpty()) {
                toLeft = !toLeft;
                cur = next;
                next = new ArrayList<>();

                if (!cur.isEmpty()) {
                    ans.add(cur.stream().mapToInt(n -> n.val).boxed().toList());
                }
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
