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
    public void inorder (TreeNode root,TreeNode [] prev, boolean [] flag){
        if(root==null) return;
        inorder(root.left,prev,flag);
        if(prev[0]==null) prev[0]=root;
        else if(root.val<=prev[0].val){
            flag[0]=false;
        }
        else prev[0]=root;
        inorder(root.right,prev,flag);
    }
    public boolean isValidBST(TreeNode root) {
      TreeNode prev[]= {null};
        boolean flag[]={true};
        inorder(root,prev,flag);
        return flag[0];
        
    }
}