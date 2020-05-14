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

// Solution 2 
class Trie2 {

    private final Entry root = new Entry(null);
    
    /** Initialize your data structure here. */
    public Trie2() {
        
    }
    
    private class Entry {
        public Character c;
        public Map<Character, Entry> next = new HashMap<>();
        
        public Entry(Character c) {
            this.c = c;
        }
        
        public Entry addEntry(Character c) {
            Entry e = next.get(c);
            if (e == null){
                e = new Entry(c);
                next.put(c, e);
            }
            return e;
        }
        
        public Entry getEntry(Character c) {
            return next.get(c);
        }
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        Entry current = root;
        for (Character c : word.toCharArray()) {
            current = current.addEntry(c);
        }
        current.addEntry(null);
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Entry current = root;
        for (Character c : word.toCharArray()) {
            Entry e = current.getEntry(c);
            if (e != null) {
                current = e;
            } else {
                return false;
            }
        }
        Entry end = current.getEntry(null);
        return end != null;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Entry current = root;
        for (Character c : prefix.toCharArray()) {
            Entry e = current.getEntry(c);
            if (e != null) {
                current = e;
            } else {
                return false;
            }
        }
        return true;
    }
}






