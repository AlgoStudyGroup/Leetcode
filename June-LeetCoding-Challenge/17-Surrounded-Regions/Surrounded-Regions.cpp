const int dx[4] = {-1, 0, 1, 0};
const int dy[4] = {0, -1, 0, 1};

class Solution {
public:
    int n, m;
    void bfs(int x0, int y0, vector<vector<char>>& board, vector<vector<int>>& vis){
        queue<pair<int, int>> q;
        vis[x0][y0] = 1;
        q.push(make_pair(x0, y0));
        while(!q.empty()){
            int x = q.front().first, y = q.front().second;
            q.pop();
            for (int i = 0; i < 4; i++){
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx >= 0 and xx < n and yy >= 0 and yy < m and board[xx][yy] == 'O' and vis[xx][yy] == 0){
                    vis[xx][yy] = 1;
                    q.push(make_pair(xx,yy));
                }
            }
            
        }
    }
    
    void solve(vector<vector<char>>& board) {
        n = board.size();
        if (n == 0) return;
        m = board[0].size();
        vector<vector<int>> vis(n, vector<int>(m, 0));
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' and vis[i][0] == 0)
                bfs(i, 0, board, vis);
            if (board[i][m-1] == 'O' and vis[i][m-1] == 0)
                bfs(i, m-1, board, vis);
        }
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O' and vis[0][i] == 0)
                bfs(0, i, board, vis);
            if (board[n-1][i] == 'O' and vis[n-1][i] == 0)
                bfs(n-1, i, board, vis);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (board[i][j] == 'O' and vis[i][j] == 0) board[i][j] = 'X';
               
    }
};