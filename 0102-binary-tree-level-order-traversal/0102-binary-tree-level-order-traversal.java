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
        if(root==null || (root.left==null && root.right==null)){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
        public static void LevelOrderT(TreeNode root , int n, List<Integer>list){

       if(root==null){
        return;
       }
       if(n==1){
        list.add(root.val);
        return;
       }
       LevelOrderT(root.left,n-1,list);
       LevelOrderT(root.right,n-1,list);
        }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList <List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        int level=1+height(root);
        for(int i=1; i<=level; i++){
            ArrayList<Integer> list = new ArrayList<>();
            LevelOrderT(root,i,list);
            ans.add(list);


        }
        return ans;
    }
}