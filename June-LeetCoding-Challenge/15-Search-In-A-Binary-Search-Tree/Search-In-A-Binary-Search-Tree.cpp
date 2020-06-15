class Solution {
public:
    TreeNode* searchBST(TreeNode* root, int val) {
        if (root == NULL) return NULL;
        if (root->val == val) return root;
        if (root->val < val) return searchBST(root->right, val);
        if (root->val > val) return searchBST(root->left, val);
        return NULL;
    }
};

class Solution2 {
public:
    TreeNode* searchBST(TreeNode* root, int val) {
        stack<TreeNode*> st;
        
        while(!st.empty() || root){
            while(root){
                st.push(root);
                root = root->left;
            }
            
            TreeNode* t = st.top();
            if(t->val == val) return t;
            if(t->val > val) return nullptr;
            st.pop();
            
            if(t->right)
                root = t->right;
            
        }
        return nullptr;
    }
};
