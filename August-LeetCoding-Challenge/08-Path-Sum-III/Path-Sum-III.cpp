class Solution {
public:
    int cpt = 0;
    int pathSum(TreeNode* root, int sum) {
        recur(root, sum);
        return cpt;
    }
    void recur(TreeNode* root, int sum, bool isConsecutive = false){
        if(!root) return;
        if(sum == root->val) ++cpt;
        recur(root->left, sum - root->val, true);
        recur(root->right, sum - root->val, true);            
        if(!isConsecutive){
            recur(root->left, sum, false);
            recur(root->right, sum, false);           
        }
    }
};
