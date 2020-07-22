class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> r;
        queue<TreeNode*> q;
        if(root) q.push(root);
        int h = 1, n;
        while(!q.empty()){
            n = q.size();
            vector<int> ins;
            for(int i=0; i<n; ++i){
                auto node = q.front(); q.pop();                                   
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
                ins.push_back(node->val);
            }
            if(!(h&1))
                reverse(ins.begin(),ins.end());
            r.push_back(ins);                
            ++h;
        }
        return r;
    }
};
