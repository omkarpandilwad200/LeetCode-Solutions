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
    public TreeNode BalancedBST(int [] nums,int l,int h){
       if(l>h) return null;
        int mid=(l+h)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=BalancedBST(nums,l,mid-1);
        root.right=BalancedBST(nums,mid+1,h);
        return root;
        

    }
    public TreeNode sortedArrayToBST(int[] nums) {
       int num = nums.length;
      return  BalancedBST(nums,0,num-1);
        
    }
}