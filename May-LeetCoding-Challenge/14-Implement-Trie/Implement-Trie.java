// Solution 1 
class Trie {
    
    private class Node{
        private boolean is_Word;
        private TreeMap<Character,Node>next;
        
        public Node(){
            this.next = new TreeMap<Character,Node>();
            this.is_Word = false;
        }
    }
    
    private Node node;

    /** Initialize your data structure here. */
    public Trie() {
        node = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = node;
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!cur.next.containsKey(ch)){
                cur.next.put(ch,new Node());
            }
            cur = cur.next.get(ch);
        }
        cur.is_Word = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = node;
        boolean flag = false;
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!cur.next.containsKey(ch)){
                return flag;
            }
            cur = cur.next.get(ch);
        }
        return cur.is_Word;        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = node;
        for(int i = 0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(!cur.next.containsKey(ch)){
                return false;
            }
            cur = cur.next.get(ch);
        }
        return true;           
    }
}





