class Solution {
    private boolean hasFind = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (hasFind) {
            return null;
        }

        if (root == null) {
            return null;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        if (hasFind){
            return l;
        }
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (hasFind){
            return r;
        }

        if (l != null && r != null) {
            hasFind = true;
            return root;
        } else if (l != null || r != null) {
            hasFind = root.val == p.val || root.val == q.val;
            if (hasFind){
                return root;
            }else{
                return l != null ? l : r;
            }
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        } else {
            return null;
        }
    }
}