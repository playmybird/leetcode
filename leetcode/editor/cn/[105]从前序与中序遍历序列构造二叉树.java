//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2444 👎 0


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
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildSubTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        int rootIndex = inLeft;
        while (rootIndex < inRight) {
            if (inorder[rootIndex] == preorder[preLeft]) {
                break;
            }
            rootIndex++;
        }

        int leftSubTreeLen = rootIndex - inLeft;
        int prel = preLeft + 1;
        int prer = preLeft + leftSubTreeLen;
        int inl = inLeft;
        int inr = rootIndex - 1;
        TreeNode leftSub = buildSubTree(preorder, prel, prer, inorder, inl, inr);

        prel = prer + 1;
        prer = preRight;
        inl = rootIndex + 1;
        inr = inRight;
        TreeNode rightSub = buildSubTree(preorder, prel, prer, inorder, inl, inr);

        return new TreeNode(inorder[rootIndex], leftSub, rightSub);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
