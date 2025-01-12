class Solution {
    final int defaultMin = -1000;
    private int max = defaultMin;

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return defaultMin;
        }

        int l = postOrder(root.left);
        int r = postOrder(root.right);

        var pathMax = Math.max(root.val, root.val + Math.max(l, r));
        max = Math.max(max, Math.max(pathMax, root.val + l + r));
        return pathMax;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxPathSum(new TreeNode(1, new TreeNode(2), null)));
    }
}