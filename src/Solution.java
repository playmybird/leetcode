class Solution {
    TreeNode lastVisitNode = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean ans = isValidBST(root.left);
        if (!ans) {
            return false;
        }

        if (lastVisitNode != null) {
            if (!(lastVisitNode.val < root.val)) {
                return false;
            }
        }
        lastVisitNode = root;

        return isValidBST(root.right);
    }
}