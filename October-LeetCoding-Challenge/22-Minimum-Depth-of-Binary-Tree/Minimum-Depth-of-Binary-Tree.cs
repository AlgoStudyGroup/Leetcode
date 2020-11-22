using System.Collections;
using System.Collections.Generic;
using System;

namespace _111_Minimum_Depth_of_Binary_Tree
{
    public class Solution
    {
        public int MinDepth(TreeNode root)
        {
            if (root == null) return 0;
            var queue = new Queue<TreeNode>();
            queue.Enqueue(root);
            int layer = 1;
            while (queue.Count > 0)
            {
                int size = queue.Count;
                //each tree layer
                for (int i = 0; i < size; i++)
                {
                    var node = queue.Dequeue();
                    if (node != null)
                    {
                        if (node.left == null && node.right == null) return layer;
                        if (node.left != null) queue.Enqueue(node.left);
                        if (node.right != null) queue.Enqueue(node.right);
                    }
                }
                layer++;
            }

            return layer;
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
}