class Solution { 
    public boolean contains(TreeNode root, TreeNode node){
        if(root==null){
            return false;
        }
        if(root==node) return true;
        return contains(root.left,node) || contains(root.right,node);
    } 

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root || q==root) return root;
        if(p==q) return p;

        // ONLY 2 CALLS: If it's on the left, it's true. If not, it's on the right.
        boolean leftp = contains(root.left, p);
        boolean leftq = contains(root.left, q);

        // Your exact logic condition, fixed to be symmetrical
        if((leftp && !leftq) || (!leftp && leftq)) return root;
        
        // Your exact traversal logic
        if(leftp && leftq) return lowestCommonAncestor(root.left, p, q);
        if(!leftp && !leftq) return lowestCommonAncestor(root.right, p, q);

        return root;
    } 
}
