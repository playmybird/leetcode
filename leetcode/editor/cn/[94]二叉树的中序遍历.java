//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2164 👎 0


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
//import java.util.ArrayList;
//import java.util.List;
//
//class Solution {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        midVisit(root, ans);
//        return ans;
//    }
//
//    private void midVisit(TreeNode root, List<Integer> ans){
//        if (root==null){
//            return;
//        }
//
//        midVisit(root.left, ans);
//        ans.add(root.val);
//        midVisit(root.right, ans);
//    }
//}


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                // visit left
                stack.push(root);
                root = root.left;
            }

            // left son has visited and pop to visit root
            root = stack.pop();
            ans.add(root.val);

            // visit right son
            root = root.right;
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
