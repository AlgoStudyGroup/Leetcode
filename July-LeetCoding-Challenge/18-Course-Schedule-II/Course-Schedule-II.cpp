class Solution {
public:
    
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> deg(numCourses, 0);
        vector<vector<int>> G(numCourses, vector<int>());
        for (auto v: prerequisites){
            deg[v[0]] ++;
            G[v[1]].push_back(v[0]);
        }
        

        queue<int> q;
        for (int i = 0; i < numCourses; i++) if (!deg[i]) q.push(i);

        vector<int> ans;
        while(!q.empty()){
            int i = q.front(); q.pop();
            ans.push_back(i);
            for (auto j: G[i]){
                deg[j]--;
                if (!deg[j]) q.push(j);
            }
        }

        if (ans.size() == numCourses) return ans;
        return vector<int>();       
    }
};