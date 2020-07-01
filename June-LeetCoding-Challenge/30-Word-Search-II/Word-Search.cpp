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




const int dx[4] = { -1, 0, 1, 0 };
const int dy[4] = { 0, -1, 0, 1 };
#define ALPHABET_SIZE 26

class Solution2 {
private:
	class Trie {
        public:
            bool isEnd;
            bool isUsed;
            unique_ptr<Trie> links[ALPHABET_SIZE];
            /** Initialize your data structure here. */
            Trie() {
                this->isEnd = false;
                this->isUsed = false;
            }

            bool containsChar(char ch) {
                return links[ch - 'a'] != nullptr;
            }
            void put(char ch, Trie* newt) {
                links[ch - 'a'].reset(newt);
            }

            Trie* get(char ch) {
                return links[ch - 'a'].get();
            }

            /** Inserts a word into the trie. */
            void insert(string word) {
                // start from root node
                Trie* root = this;
                for (int i = 0; i < word.length(); i++) {
                    // create a new node if path doesn't exists
                    if (!root->containsChar(word[i])) {
                        root->put(word[i], new Trie());
                    }
                    root = root->get(word[i]);
                }
                // make current node as a keyword
                root->isEnd = true;
            }

            ~Trie() {}
	};
public:
	vector<string> r;

    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
		Trie* root = new Trie();
		for (const string& s : words)
			root->insert(s);

		string acc;
		for (int i = 0, lenx = board.size(); i < lenx; ++i) 
			for (int j = 0, leny = board[0].size(); j < leny; ++j) 
					explore(board, i, j, root, acc);
        
		delete root;
		return r;

    }

	void explore(vector<vector<char>>& board, int i, int j, Trie* root, string& acc) {
		char curr = board[i][j];
		if (curr== '#' || !root->containsChar(curr)) return;
		
		acc.push_back(curr);
		root = root->get(curr);
		if (root->isEnd) {
            if(!root->isUsed){      // in case of board = [["a","a"]], words = ["a"] 
                r.push_back(acc);
                root->isUsed = true;               
            }
		}
        
		board[i][j] = '*';
		for (int k = 0; k < 4; ++k) {
			int tox = i + dx[k], toy = j + dy[k];
			if (tox < board.size() && tox >= 0 && toy >= 0 && toy < board[0].size() && board[tox][toy] != '*') 
				explore(board, tox, toy, root, acc);
			
		}
        
		acc.pop_back();
		board[i][j] = curr;
	}
};
