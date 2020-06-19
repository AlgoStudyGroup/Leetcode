public class Solution {
    public TreeNode InvertTree(TreeNode root) {
        if (root != null)
        {        
          InvertTree(root.left);
          InvertTree(root.right);
          TreeNode temps = root.left;
          root.left=root.right;
          root.right= temps;
        }    
      return root;  
    }
}
