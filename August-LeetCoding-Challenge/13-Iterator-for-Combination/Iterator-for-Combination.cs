public class CombinationIterator {

    private Queue<string> queue = new Queue<string>();
    
    public CombinationIterator(string characters, int combinationLength) {
        Dfs(characters, 0, "", combinationLength);
    }
        
    public string Next() {
        return queue.Dequeue();
    }
    
    public bool HasNext() {
        return queue.Count > 0;
    }
    
    private void Dfs(string chars, int start, string curr, int length){
        if(length == 0){
            queue.Enqueue(curr);
        }
        for(int i=start; i<chars.Length; i++){
            Dfs(chars, i+1, curr + chars[i], length-1);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * string param_1 = obj.Next();
 * bool param_2 = obj.HasNext();
 */