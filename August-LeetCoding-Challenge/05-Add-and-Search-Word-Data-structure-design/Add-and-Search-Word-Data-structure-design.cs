public class WordDictionary {

    private TrieNode _root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        _root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void AddWord(string word) {
        var node = _root;
        foreach(char c in word){
            if(node.Children[c - 'a'] == null){
                node.Children[c - 'a'] = new TrieNode();
            }
            node = node.Children[c - 'a'];
        }
        node.IsWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public bool Search(string word) {
        return Match(word.ToCharArray(), 0, _root);
    }
    
    private bool Match(char[] arr, int i, TrieNode node){
        if(i == arr.Length) return node.IsWord;
        
        if(arr[i] == '.'){
            for(int j=0; j<node.Children.Length; j++){
                if(node.Children[j] != null && Match(arr, i+1, node.Children[j])){
                    return true;
                }
            }
        } else {
           return node.Children[arr[i] - 'a'] != null && Match(arr, i+1, node.Children[arr[i] -'a']); 
        }
        return false;
    }
}

public class TrieNode{
    public TrieNode[] Children = new TrieNode[26];
    public bool IsWord {get;set;}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.AddWord(word);
 * bool param_2 = obj.Search(word);
 */