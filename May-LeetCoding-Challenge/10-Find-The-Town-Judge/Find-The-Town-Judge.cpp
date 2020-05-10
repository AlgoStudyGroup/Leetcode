class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        vector<int> deg_in(N+1, 0);
        vector<int> deg_out(N+1, 0);
        for (auto &v: trust){
            deg_out[v[0]]++;
            deg_in[v[1]]++;       
        }
        
        int ans = -1;
        for (int i = 1; i <= N; i++)
            if (deg_in[i] == N-1 and deg_out[i] == 0){
                if (ans == -1) ans = i;
                else return -1;
            }  
        return ans;
    }
};