class Solution {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        // yahin diameter update hota hai
        max = Math.max(max, lh + rh);

        return Math.max(lh, rh) + 1;
    }
}
