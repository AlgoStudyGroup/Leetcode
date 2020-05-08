# Cousins-In-Binary-Tree

https://leetcode.com/problems/cousins-in-binary-tree/, Easy

Strategy:

- Breadth-first search (BFS)
- DFS

## BFS

Walk through the tree level-by-level and save the node if its value matches `x`
or `y`. Two nodes are cousins if they have the same depth but have different
parents. To know if two nodes have the same parent, we also need to save the
parent information as well. Therefore, instead of walking through nodes, we walk
through node-pairs, where the 1st element is parent node, and the 2nd element is
current node. The queue can be represented as below in Java:

```java
// TreeNode[] { parent, current }
Queue<TreeNode[]> queue = new LinkedList<>();
```

We let the breadth-first search logic walk through the tree level-by-level.
When at least one node (x, y, or both) had been identified in the current depth
level, we stop and determine the relationship of two nodes. More detail in Java
solution.

## DFS, caching height and parent value in the attributs
the strategy consists of
1. if current node is x/y.
2. if it is the case, caching height and parent value.
3. if not the case, continue to do so for left branch and right branch.
