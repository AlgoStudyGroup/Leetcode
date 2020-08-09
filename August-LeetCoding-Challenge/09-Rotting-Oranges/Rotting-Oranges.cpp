
const int dx[4] = { -1, 0, 1, 0 };
const int dy[4] = { 0, -1, 0, 1 };
typedef pair<int,int> ip;
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        const int m=grid.size(), n=grid[0].size();
        unordered_set<int> freshes;
        queue<ip> rottens;
        int r=0;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j]){
                    if(grid[i][j]==1) freshes.insert(n*i+j);
                    else rottens.emplace(i,j);
                }
            }
        }
        while(!rottens.empty()){
            for(int i=0, qsz=rottens.size(); i<qsz; ++i){
                ip f=rottens.front(); rottens.pop(); auto [x,y] = f;
                for(int j=0; j<4; ++j){
                    int tox=dx[j]+x, toy=dy[j]+y, ind = n*tox+toy;
                    if(tox>=0 && toy>=0 && tox<m && toy<n && freshes.count(ind)) 
                        freshes.erase(ind), rottens.emplace(tox,toy);
                }
                
            }
            if(!rottens.empty())
                ++r;           
        }
        if(!freshes.empty()) return -1;
        else return r;
    }
};
