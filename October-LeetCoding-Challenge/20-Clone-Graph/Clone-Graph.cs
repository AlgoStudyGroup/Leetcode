using System;
using System.Collections.Generic;
using System.Collections;

namespace _133_Clone_Graph
{
    public class Solution
    {
        Dictionary<Node, Node> map = new Dictionary<Node, Node>();
        public Node CloneGraph(Node node)
        {
            if (node == null) return null;
            if (!map.ContainsKey(node))
            {
                map.Add(node, new Node(node.val));
                foreach (var nei in node.neighbors)
                {
                    map[node].neighbors.Add(CloneGraph(nei));
                }
            }
            return map[node];
        }
    }

    public class Node
    {
        public int val;
        public IList<Node> neighbors;

        public Node()
        {
            val = 0;
            neighbors = new List<Node>();
        }

        public Node(int _val)
        {
            val = _val;
            neighbors = new List<Node>();
        }

        public Node(int _val, List<Node> _neighbors)
        {
            val = _val;
            neighbors = _neighbors;
        }
    }

}