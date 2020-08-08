public class Solution {
    public int PathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        var map = new Dictionary<int, int>();
        map[0] = 1;
        return Dfs(root, 0, sum, map); 
    }
    
     private int Dfs(TreeNode curr, int sum, int target, Dictionary<int, int> map) {
        if (curr == null) {
            return 0;
        }
        // update the prefix sum by adding the current val
        sum += curr.val;
        // get the number of valid path, ended by the current node
        int numPathToCurr = map.ContainsKey(sum-target) ? map[sum-target] : 0; 
        // update the map with the current sum, so the map is good to be passed to the next recursion
        map[sum] = (map.ContainsKey(sum) ? map[sum] : 0) + 1;
        // add the 3 parts discussed in 8. together
        int res = numPathToCurr + Dfs(curr.left, sum, target, map)
                  + Dfs(curr.right, sum, target, map);
       // restore the map, as the recursion goes from the bottom to the top
        map[sum] -= 1;
        return res;
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