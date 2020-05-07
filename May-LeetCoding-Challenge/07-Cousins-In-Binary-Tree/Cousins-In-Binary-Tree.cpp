class Solution {
private:
    int x, y;
public:
    bool check(TreeNode* p, TreeNode* q){
        if(p == NULL or q == NULL) return false;

        if (((p->left and p->left->val == x) or (p->right and p->right->val == x))
            and 
            ((q->left and q->left->val == y) or (q->right and q->right->val == y)))
        return !(p == q);

        return check(p->left, q->left) or check(p->right, q->left) or check(p->left, q->right) or check(p->right, q->right);
    }
    bool isCousins(TreeNode* root, int x, int y) {
        this->x = x;
        this->y = y;
        return check(root,root);
    }
};