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
    public int height(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public void levelTraversal(TreeNode root, int n, List<Integer> list) {
        if(root==null) return;
        if (n == 1) {
            list.add(root.val);
            return;
        }
        levelTraversal(root.left, n - 1, list);
        levelTraversal(root.right, n - 1, list);
    }

    public void levelTraversal2(TreeNode root, int n, List<Integer> list) {
        if(root==null) return;
        if (n == 1) {
            list.add(root.val);
            return;

        }
        levelTraversal2(root.right, n - 1, list);
        levelTraversal2(root.left, n - 1, list);

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        int level = 1 + height(root);
        for (int i = 1; i <= level; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            // if(root==null){
            //     return ans;
            // }
            if (i % 2 != 0) {
                levelTraversal(root, i, list);
            } else {
                levelTraversal2(root, i, list);
                
            }
            ans.add(list);
        }
        return ans;
    }
}