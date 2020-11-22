namespace _116_Populating_Next_Right_Pointers_in_Each_Node
{
    public class Solution
    {
        public Node Connect(Node root)
        {
            var node = root;
            while (root != null && root.left != null)
            {
                Node cur = root;
                while (cur != null)
                {
                    cur.left.next = cur.right;
                    cur.right.next = cur.next == null ? null : cur.next.left;
                    cur = cur.next;
                }
                root = root.left;
            }
            return node;
        }
    }

    public class Node
    {
        public int val;

        public Node left;

        public Node right;

        public Node next;

        public Node()
        {
        }

        public Node(int _val)
        {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next)
        {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
