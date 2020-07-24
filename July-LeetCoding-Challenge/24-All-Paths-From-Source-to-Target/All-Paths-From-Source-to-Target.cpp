class Solution1 {
public:
    vector<vector<int>> r;
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        const int N = graph.size();
        vector<int> ins;
        dfs(0, N, graph, ins);
        return r;
    }
    
    void dfs(int curr, const int N, vector<vector<int>>& adj, vector<int>& ins){
        if(curr == N-1){
            ins.push_back(curr);
            r.push_back(ins);
            return;
        }
        ins.push_back(curr);
        for(int i: adj[curr]){
            dfs(i, N, adj, ins);
            ins.pop_back();
        }
    }
};
