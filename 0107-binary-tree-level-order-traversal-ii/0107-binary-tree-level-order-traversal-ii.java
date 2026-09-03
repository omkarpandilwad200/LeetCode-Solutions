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
    public int height(TreeNode root){
        if(root==null  || (root.left==null && root.right==null))
        return 0;
    
    return 1+Math.max(height(root.left),height(root.right));
    }

    public void levelOrderTraversal(TreeNode root,int n,List<Integer> list){
        if(root==null){
            return;
        }
                if(n==1){
            list.add(root.val);
            return;
        }

        levelOrderTraversal(root.left,n-1,list);
        //         if(n==1){
        //     list.add(root.val);
        //     return;
        // }

        levelOrderTraversal(root.right,n-1,list);
        // if(n==1){
        //      list.add(root.val);
        //      return;
        //  }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList <List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        int level= 1+height(root);

        for(int i=level; i>=1; i--){
            ArrayList<Integer> list = new ArrayList<>();
            levelOrderTraversal(root,i,list);
            ans.add(list);
        }
        return ans;
        
    }
}