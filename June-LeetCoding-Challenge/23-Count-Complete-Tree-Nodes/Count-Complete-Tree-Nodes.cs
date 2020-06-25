public class Solution
{
    //Solution 1
    // Runtime: 100 ms, faster than 96.07% of C# online submissions for Count Complete Tree Nodes.
    // Memory Usage: 32.3 MB, less than 97.70% of C# online submissions for Count Complete Tree Nodes.
    public int CountNodes(TreeNode root)
    {
        var count = 0;
        if (root == null)
        {
            return count;
        }
        DfsPreorderTraversal(root, ref count);
        return count;
    }
    public void DfsPreorderTraversal(TreeNode node, ref int count)
    {
        if (node != null)
        {
            count++;
        }
        if (node.left != null)
        {
            DfsPreorderTraversal(node.left, ref count);
        }
        if (node.right != null)
        {
            DfsPreorderTraversal(node.right, ref count);
        }
        return;
    }

    //Solution 2
    // Runtime: 112 ms, faster than 50.00% of C# online submissions for Count Complete Tree Nodes.
    // Memory Usage: 32.5 MB, less than 87.10% of C# online submissions for Count Complete Tree Nodes.
    public int CountNodes(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        return 1 + CountNodes(root.left) + CountNodes(root.right);
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