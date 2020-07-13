class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if (p == NULL and q == NULL) return true;
        if (p == NULL and q) return false;
        if (p and q == NULL) return false;
        if (p->val != q->val) return false;
        return isSameTree(p->left, q->left) and isSameTree(p->right, q->right);
    }
};