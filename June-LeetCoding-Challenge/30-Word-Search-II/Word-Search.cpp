class Trie {
public:
    vector<vector<int>> ch;
    vector<int> val;
    int size;
    
    /** Initialize your data structure here. */
    Trie() {
        size = 1;
        ch.resize(1);
        ch[0].resize(26);
        val.resize(1);
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        int cur = 0, n = word.length();
        for (int i = 0; i < n; i++){
            int j = word[i] - 'a';
            if (!ch[cur][j]){
                ch.push_back(vector<int>(26, 0));
                val.push_back(0);
                ch[cur][j] = size++;
            }
            cur = ch[cur][j];
        }
        val[cur] = 1;
    }
};

const int dx[4] = {-1, 0, 1, 0};
const int dy[4] = {0, -1, 0, 1};

struct T {
    int x, y, r;
    string str;
    T(){}
    T(int x, int y, int r, string str):x(x),y(y),r(r), str(str){}
};

class Solution {
public:
    int n, m;
    Trie* t;
    set<string> s;
    
    void dfs(int x, int y, int r, string u, vector<vector<char>>& board, vector<vector<int>>& vis){
    
        if (!r) return;
    
        if (t->val[r]) s.insert(u);
    
        for (int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
                if (xx >= 0 and xx < n and yy >= 0 and yy < m and t->ch[r][board[xx][yy]-'a'] and !vis[xx][yy]){
                    int rr = t->ch[r][board[xx][yy]-'a'];
                    vis[xx][yy] = 1;

                    string uu = u;
                    uu += board[xx][yy];
                    if (t->val[rr]) s.insert(uu);

                    dfs(xx, yy, rr, uu, board, vis);
                    vis[xx][yy] = 0;
                }
            
        }
    }
    
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        t = new Trie();
        for (auto& s: words) t->insert(s);
        
        n = board.size();
        if (n == 0) return vector<string>();
        m = board[0].size();
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++){
                vector<vector<int>> vis(n, vector<int>(m, 0));
                vis[i][j] = 1;
                string u;
                u += board[i][j];
                dfs(i, j, t->ch[0][board[i][j]-'a'], u, board, vis);
            }
        
        vector<string> ans;
        for (auto tmp: s)
            ans.push_back(tmp);
        return ans;
                
    }
};