const int dx[4] = {-1, 0, 1, 0};
const int dy[4] = {0, -1, 0, 1};

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        int n = image.size();
        if (n == 0) return image;
        int m = image[0].size();
        
        queue<pair<int,int>> q;
        q.push(make_pair(sr, sc));
        vector<vector<int>> vis(n, vector<int>(m, 0));
        vis[sr][sc] = 1;
        int c = image[sr][sc];
        image[sr][sc] = newColor;
        
        while(!q.empty()){
            auto cur = q.front();
            q.pop();
            for (int i = 0; i < 4; i++){
                int x = cur.first + dx[i];
                int y = cur.second + dy[i];
                if (0 <= x and x < n and 0 <= y and y < m and !vis[x][y] and image[x][y] == c){
                    q.push(make_pair(x, y));
                    vis[x][y] = 1;
                    image[x][y] = newColor;
                }
            }
        }
        return image;
    }
};