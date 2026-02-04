class Solution {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        max = Math.max(max, lh + rh);

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return max;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }
}
