class Solution {
public:
    TreeNode* construct(int i, int j, vector<int>& preorder){
        if (i > j) return NULL;
        TreeNode* root = new TreeNode(preorder[i]);
        int k = i;
        while (k <= j and preorder[k] <= preorder[i]) k++;
        root->left = construct(i+1, k-1, preorder);
        root->right = construct(k, j, preorder);
        return root;
    }
    
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        return construct(0, preorder.size() - 1, preorder);
    }
};

class Solution2 {
public:
    /* iterative, time : ~O(n log logn), space : O(n) */
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        TreeNode **v = new TreeNode*[preorder.size()];
        int curr_val, root_val = preorder[0];
        int pos = 0;
        TreeNode *root = new TreeNode(root_val);
        TreeNode *node = root;
        v[0] = root;
        
        for (int i = 1; i < preorder.size() ; ++i) {
            curr_val = preorder[i];
            if (preorder[i-1] > curr_val) {
                node->left = new TreeNode(curr_val);
                node = node->left;
                v[++pos] = node;
            } else { /* find the target father node */
                if (curr_val > root_val) {
                    pos = 0;
                    root_val = curr_val;
                } else {
                    /* interpolation search, do more time if data is large */
                    pos = ((curr_val - root_val) * (pos)) / (v[pos]->val - root_val);
                    pos = max(0, pos);
                    
                    /* target is near pos */
                    if (v[pos]->val > curr_val) {
                        while (v[++pos]->val > curr_val);
                    } else {
                        while (curr_val > v[--pos]->val);
                        ++pos;
                    }
                }
                node = new TreeNode(curr_val);
                v[pos]->right = node;
                v[pos] = node;
            }
        }
        return root;
    }
};
