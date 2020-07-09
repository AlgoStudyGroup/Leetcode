typedef pair<TreeNode*, unsigned long> tp; // use unsigned long to pass a tricky testcase..
class Solution1 {
public:
    int widthOfBinaryTree(TreeNode* root) {
        queue<tp> q;
        if (root) q.emplace(root, 1);
        int maxW = 0;
        while (!q.empty()) {
            const int n = q.size();
            unsigned long lm = INT_MAX, rm = 0;
            for (int i = 0; i < n; ++i) {
                auto f = q.front(); q.pop();
                lm = min(lm, f.second);
                rm = max(rm, f.second);
                if (f.first->left) q.emplace(f.first->left, 2*f.second);
                if (f.first->right) q.emplace(f.first->right, 2*f.second + 1);
            }
            maxW = max(maxW, (int)(rm - lm + 1));
        }
        return maxW;
    }
};
