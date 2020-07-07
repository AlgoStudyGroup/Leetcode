const int dx[4] = {-1, 0, 1, 0};
const int dy[4] = {0, -1, 0, 1};

class Solution {
public:
    int n, m;
    
    void bfs(int x0, int y0, vector<vector<int>>& grid, vector<vector<int>>& vis){
        queue<pair<int, int>> q;
        q.push(make_pair(x0, y0));
        vis[x0][y0] = 1;
        while(!q.empty()){
            auto cur = q.front();
            q.pop();
            for (int i = 0; i < 4; i++){
                int x = cur.first + dx[i];
                int y = cur.second + dy[i];
                if (x >=0 and x < n and y >=0 and y < m and !vis[x][y] and grid[x][y] == 1){
                    vis[x][y] = 1;
                    q.push(make_pair(x, y));
                }
            }
        }
        
    }
    
    void count (int& sum, int x, int y, vector<vector<int>>& grid, vector<vector<int>>& vis){
        int num = 0;
        for (int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            
            if (xx >=0 and xx < n and yy >=0 and yy < m and vis[xx][yy] and grid[x][y] == 1)
                    num ++;
        }
        sum += 4 - num;
        
    }
    
    int islandPerimeter(vector<vector<int>>& grid) {
        n = grid.size();
        if (n == 0) return 0;
        m = grid[0].size();
        vector<vector<int>> vis(n, vector<int>(m, 0));
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!vis[i][j] and grid[i][j] == 1)
                    bfs(i, j, grid, vis);
        
        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (vis[i][j])
                count(sum, i, j, grid, vis);
        return sum;
    }
};