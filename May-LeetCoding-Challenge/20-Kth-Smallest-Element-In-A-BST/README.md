# Kth Smallest Element in a BST

<https://leetcode.com/problems/kth-smallest-element-in-a-bst/>, Medium

Strategy:

- In-order traversal

## In-Order Traversal

To find the Kth smallest element in a binary search tree (BST), we can traverse
its nodes in-order: left, node, right (LNR). This is because all the nodes in
left sub-tree have value smaller than the current node, and all the nodes in the
right sub-tree have value greater than the current node. In-order traversal
makes us find the result in the shortest time. When walking through the tree,
keep track of two variables: the candidate for the Kth smallest value and the
remaining number of nodes to visit. We stop visiting more nodes when remaining
node count decreases and reaches 0. Possible solution in Java:

```java
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return walk(root, k)[0];
    }

    /**
     * Finds the Kth smallest element by walking through
     * the tree in in-order: left, node, right (LNR).
     *
     * @return a pair containing the candidate for the Kth smallest
     *         value and the remaining number of nodes to visit
     */
    private int[] walk(TreeNode root, int k) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE, k };
        }
        int[] arr = walk(root.left, k);
        int candidate = arr[0];
        int remaining = arr[1];
        if (remaining == 0) {
            return new int[] { candidate, 0 };
        }
        if (remaining == 1) {
            return new int[] { root.val, 0 };
        }
        return walk(root.right, remaining - 1);
    }
}
```
