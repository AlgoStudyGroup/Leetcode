// Runtime: 92 ms, faster than 76.74% of C# online submissions for Sum Root to Leaf Numbers.
// Memory Usage: 24.6 MB, less than 5.88% of C# online submissions for Sum Root to Leaf Numbers.
public class Solution {
    public int SumNumbers(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;

        var result = 0;
        Calculate(0, root, ref result);
        return result;
    }
    
    public void Calculate(int v, TreeNode node, ref int num)
    {
        if(node != null)
        {
            v = v * 10 + node.val;
            if(node.left == null && node.right == null)
            {
                num +=v;
            }
            if(node.left != null)
            {
                Calculate(v, node.left, ref num);    
            }
            if(node.right != null)
            {
                Calculate(v, node.right, ref num);
            }
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