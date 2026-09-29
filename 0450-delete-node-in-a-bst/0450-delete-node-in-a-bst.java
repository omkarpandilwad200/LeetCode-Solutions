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
      public static void delete(TreeNode root, int target){
      if(root == null) return;
      
      if(root.val > target){ // go left
          if(root.left == null) return;
          if(root.left.val == target){
              TreeNode l = root.left; // l is that node that i wish to delete
              if(l.left == null && l.right == null){ // 0 children
                  root.left = null;
              } 
              else if(l.left == null || l.right == null){ // 1 child
                  if(l.left != null) root.left = l.left;
                  else root.left = l.right;
              }
              else{
                TreeNode curr=l;
                TreeNode pred= curr.left;
                while(pred.right!=null) pred=pred.right;
                delete(root,pred.val);
                pred.left = curr.left;
                pred.right=curr.right;
                root.left = pred;
              }
          } 
          else delete(root.left, target);
      } 
      else { // go right
          if(root.right == null) return;
          if(root.right.val == target){
              TreeNode r = root.right; // r is the node we will delete
              if(r.left == null && r.right == null) {
                  root.right = null;
              }
             
              else if(r.left == null || r.right == null){ // 1 child
                  if(r.left != null) root.right = r.left;
                  else root.right = r.right;
              }
                else{
                TreeNode curr=r;
                TreeNode pred= curr.left;
                while(pred.right!=null) pred=pred.right;
                delete(root,pred.val);
                pred.left = curr.left;
                pred.right=curr.right;
                root.right = pred;
              }
          }
         
          else delete(root.right, target); 
      }
  }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key){
            TreeNode head = new TreeNode(Integer.MAX_VALUE);
            head.left=root;
            delete(head,key);
            return head.left;

        }
         delete(root,key);
         return root;
    }
}