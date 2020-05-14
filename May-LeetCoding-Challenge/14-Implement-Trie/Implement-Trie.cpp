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
    
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        int cur = 0, n = word.length();
        for (int i = 0; i < n; i++){
            int j = word[i] - 'a';
            if (!ch[cur][j])
               return false;
            cur = ch[cur][j];
        }
        return val[cur] == 1;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        int cur = 0, n = prefix.length();
        for (int i = 0; i < n; i++){
            int j = prefix[i] - 'a';
            if (!ch[cur][j])
               return false;
            cur = ch[cur][j];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */