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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return root=new TreeNode(val);
      
        if(root.val>val){
            if(root.left==null){
                TreeNode temp= new TreeNode();
                temp.val=val;
                root.left=temp;
                 return root ;
            }
            else insertIntoBST(root.left,val);
          
        } 
        else {
            if(root.right==null){
                TreeNode temp= new TreeNode();
                temp.val=val;
                root.right=temp;
                return root ;
            }
            else insertIntoBST(root.right,val);
        } 
        return root;
        
        
    }
}