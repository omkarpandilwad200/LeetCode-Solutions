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
    public TreeNode helper(int [] inorder, int inlow,int inhigh, int [] postorder,int postlow,int posthigh)
    {
        if(posthigh<postlow) return null;
        TreeNode root=new TreeNode(postorder[posthigh]);
        int i=inlow;
        while(inorder[i]!=postorder[posthigh]) i++;
        int leftsize=i-inlow;
        root.left=helper(inorder,inlow,i-1,postorder,postlow,postlow+leftsize-1);
        root.right=helper(inorder,i+1,inhigh,postorder,postlow+leftsize,posthigh-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n =inorder.length;
        return helper(inorder,0,n-1,postorder,0,n-1);
    }
}