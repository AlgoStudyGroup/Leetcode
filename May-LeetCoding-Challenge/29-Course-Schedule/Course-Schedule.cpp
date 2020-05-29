class Solution {
public:
   
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> deg(numCourses, 0);
        vector<vector<int>> G(numCourses, vector<int>());
        for (int i = 0; i < prerequisites.size(); i ++){
            deg[prerequisites[i][0]]++;
            G[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
        
        queue<int> q;
        for (int i = 0; i < numCourses; i++)  if (!deg[i]) q.push(i);
        int sum = 0;
        while(!q.empty()){
            int i = q.front(); 
            q.pop();
            sum ++;
            for (auto j: G[i]){
                deg[j]--;
                if (!deg[j]) q.push(j);
            }
        }
        
        return sum == numCourses;
        
    }
};