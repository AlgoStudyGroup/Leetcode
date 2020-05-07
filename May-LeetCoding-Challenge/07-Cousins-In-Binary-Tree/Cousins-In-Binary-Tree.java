class Solution {
    public int getDepth(TreeNode root, int v){
        if(root == null ) return -1;
        if(root.val == v) return 0;
        
        int left_d = getDepth(root.left, v);
        int right_d = getDepth(root.right, v);
        
        if(left_d >= 0) return left_d+1;
        else if(right_d >= 0) return right_d+1;
        return -1;
    }
    
    public boolean hasSameParent(TreeNode root, int x, int y){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        boolean isSame = false;
        
        if(root != null) q.add(root);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            
            if(n.left != null && n.right != null){
                isSame = n.left.val == x && n.right.val == y ||
                    n.left.val == y && n.right.val == x;
                if(isSame) return true;
            }
            if(n.left != null) q.add(n.left);
            if(n.right != null) q.add(n.right);
        }
        return false;
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        int x_d = -1, y_d = -1;
        x_d = getDepth(root, x);
        y_d = getDepth(root, y);
        
        if(x_d != -1 && y_d != -1 && x_d == y_d && !hasSameParent(root, x, y)) return true;
        return false;
    }
}