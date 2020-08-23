class StreamChecker {
    
    private Set<Character>letters = new HashSet<Character>();
    private Set<String>dictionary = new HashSet<String>();
    private List<Character>l = new ArrayList<Character>();
    private int seuil = 0;
    private int min = Integer.MAX_VALUE;
    private StringBuilder sb = new StringBuilder();
    
    private class Trie{
        private boolean isWord;
        private TreeMap<Character,Trie>next;
        
        public Trie(){
            this.isWord = false;
            next = new TreeMap<Character,Trie>();
        }
    }
    
    private Trie node = new Trie();
    
    public void add(String mot){
        Trie cur = node;
        for(int i = mot.length()-1;i >= 0;i--){
            char ch = mot.charAt(i);
            if(!cur.next.containsKey(ch)){
                cur.next.put(ch,new Trie());
            }
            cur = cur.next.get(ch);
        }
        cur.isWord = true;
    }
        
    public boolean search(String mot){
        /*
        c queue : c false
        d queue : cd true
        e queue : cde true
        f queue : def false
        k queue : k false
        l queue : kl true 
        */
        Trie cur = node;
        for(int i = 0;i < mot.length();i++){
            char ch = mot.charAt(i);
            if(!cur.next.containsKey(ch)){
                return cur.isWord;
            }
            cur = cur.next.get(ch);
            if(cur.isWord){
                //System.out.println(mot);
                return true;
            }
        }  
        //System.out.println(mot+" "+cur.isWord);
        return cur.isWord;
    }

    public StreamChecker(String[] words) {
        for(int i = 0;i < words.length;i++){
            String mot = words[i];
            seuil = Math.max(mot.length(),seuil);
            min = Math.min(mot.length(),min);
            dictionary.add(mot);
            add(mot);
            for(int j = mot.length()-1;j>=0;j--){
                char ch = mot.charAt(j);
                letters.add(ch);
            }            
        }
    }
    
    public boolean query(char letter) {
        if(!letters.contains(letter)){
            sb.delete(0,sb.length());
            return false;
        }
        sb.append(letter);
        if(sb.length()<min){return false;}
        if(sb.length()>seuil){
            sb.delete(0,1);
        }
        boolean flag = search(new StringBuilder(sb).reverse().toString());
        return flag;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
