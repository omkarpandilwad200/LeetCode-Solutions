class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null, or matches either target node
        if (root == null || root == p || root == q) {
            return root;
        }

        // Look for p and q in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides returned a non-null node, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null side
        return (left != null) ? left : right;
    }
}
