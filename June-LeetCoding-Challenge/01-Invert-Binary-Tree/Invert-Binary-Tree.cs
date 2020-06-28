public class Solution
{
    public TreeNode InvertTree(TreeNode root)
    {
        if (root != null)
        {
            InvertTree(root.left);
            InvertTree(root.right);
            TreeNode temps = root.left;
            root.left = root.right;
            root.right = temps;
        }
        return root;
    }
}

// Stack solution
// Runtime: 92 ms, faster than 78.61% of C# online submissions for Invert Binary Tree.
// Memory Usage: 24.1 MB, less than 62.37% of C# online submissions for Invert Binary Tree.
public class Solution
{
    public TreeNode InvertTree(TreeNode root)
    {
        if (root == null)
        {
            return null;
        }
        var stack = new Stack<TreeNode>();
        stack.Push(root);

        while (stack.Count > 0)
        {
            var node = stack.Pop();
            var temp = node.right;
            node.right = node.left;
            node.left = temp;
            if (node.left != null)
            {
                stack.Push(node.left);
            }
            if (node.right != null)
            {
                stack.Push(node.right);
            }
        }

        return root;
    }
}

//Code to play with for stack solution demo
public static class Program
{
    public static void Main()
    {
        var subleft = new TreeNode(4, null, null);
        var subright = new TreeNode(5, null, null);
        var left = new TreeNode(2, subleft, subright);
        var right = new TreeNode(3, null, null);
        var root = new TreeNode(1, left, right);
        InvertTree(root);
    }

    public static TreeNode InvertTree(TreeNode root)
    {
        if (root == null)
        {
            return null;
        }
        var stack = new Stack<TreeNode>();
        stack.Push(root);

        while (stack.Count > 0)
        {
            var node = stack.Pop();
            Console.WriteLine("poping:" + node.val);
            var temp = node.right;
            node.right = node.left;
            node.left = temp;
            if (node.left != null)
            {
                Console.WriteLine("pushing left node:" + node.left?.val);
                stack.Push(node.left);
            }
            if (node.right != null)
            {
                Console.WriteLine("pushing right node:" + node.right?.val);
                stack.Push(node.right);
            }
        }

        return root;
    }
}
public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val = 0, TreeNode left = null, TreeNode right = null)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}