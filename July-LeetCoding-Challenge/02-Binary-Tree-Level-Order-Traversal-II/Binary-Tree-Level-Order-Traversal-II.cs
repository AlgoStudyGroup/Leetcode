public class Solution {
        public IList<IList<int>> LevelOrderBottom(TreeNode root) {
        var result = new List<IList<int>>(); 
        var level = 0;
        Recursion(root, result, level);
        result.Reverse();
        return result;
    }
    
    private void Recursion(TreeNode node, List<IList<int>> list, int level){
        if(node == null) return;
        if(list.Count() == level) 
        {
            list.Add(new List<int>());
        }
        list[level].Add(node.val);
        
        if(node.left != null){
            Recursion(node.left, list, level+1);
        }
        if(node.right != null){
            Recursion(node.right, list, level+1);
        }
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */