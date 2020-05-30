class Solution {
public:
    vector<int> color;
    vector<vector<int>> G;
    
    // Return true if the connected component of u is a bipartite graph
    bool bipartite(int u) {
        for (int i = 0; i < G[u].size(); i++) {
            int v = G[u][i];
            if (color[v] == color[u]) return false;
            if (!color[v]) {
                color[v] = 3 - color[u];
                if (!bipartite(v)) return false;
            }
        }
        return true;
    }
    
    bool possibleBipartition(int N, vector<vector<int>>& dislikes) {
        color.resize(N+1);
        G.resize(N+1);

        
        for (int i = 0; i < dislikes.size(); i++) {
            G[dislikes[i][0]].push_back(dislikes[i][1]);
            G[dislikes[i][1]].push_back(dislikes[i][0]);
        }
        
        for (int i = 1; i <= N; i++)
            if (!color[i]){
                color[i] = 1;
                if (!bipartite(i)) return false;
            }
        return true;
        
    }
};