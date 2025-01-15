//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
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
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 2062 👎 0


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
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        List<TreeNode> cur = new LinkedList<>();
        List<TreeNode> next = new LinkedList<>();
        cur.add(root);
        ans.add(new ArrayList<>(List.of(root.val)));

        while (!cur.isEmpty()) {
            var c = cur.removeFirst();
            if (c.left != null) {
                next.add(c.left);
            }
            if (c.right != null) {
                next.add(c.right);
            }

            if (cur.isEmpty()) {
                cur = next;
                next = new LinkedList<>();

                if (!cur.isEmpty()) {
                    ans.add(new ArrayList<>(cur.stream().mapToInt(n -> n.val).boxed().toList()));
                }
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
