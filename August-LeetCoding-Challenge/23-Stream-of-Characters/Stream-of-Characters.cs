public class StreamChecker {
    private TrieNode root = new TrieNode();
    private StringBuilder sb = new StringBuilder();
    public StreamChecker(string[] words) {
        CreateTrie(words);
    }
    
    public bool Query(char letter) {
        sb.Append(letter);
        TrieNode node = root;
        for(int i = sb.Length-1; i>=0 && node!=null; i--){
            char c = sb[i];
            node = node.next[c -'a'];
            if(node != null && node.IsWord){
                return true;
            }
        }
        return false;
    }
    
    private void CreateTrie(string[] words){
        foreach(string s in words){
            var node = root;
            int length = s.Length;
            for(int i= length -1; i>=0; i--){
                char c = s[i];
                if(node.next[c - 'a'] == null){
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.IsWord = true;
        }
    }
}

public class TrieNode{
    public Boolean IsWord {get;set;}
    public TrieNode[] next = new TrieNode[26];
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * bool param_1 = obj.Query(letter);
 */