public class MyHashSet {

    private List<int>[] bucket;
    private int capacity;
    private int count = 0;
    private double loadFactor = 0.75;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        capacity = 1000;
        bucket = new List<int>[capacity];
    }
    
    public void Add(int key) {
        if(Contains(key)){
            return;
        }
        
        if(loadFactor * 2 == count){
            count = 0;
            capacity *= 2;
            var oldBucket = bucket;
            bucket = new List<int>[capacity];
            for(int i=0; i<oldBucket.Length; i++){
                var list = oldBucket[i];
                if(list != null && list.Count >0){
                    foreach(var item in list)
                        Add(item);
                }
            }
        }
        
        var hash = key % capacity;
        if(bucket[hash] == null) bucket[hash] = new List<int>();
        bucket[hash].Add(key);
        count++;
    }
    
    public void Remove(int key) {
        var hash = key % capacity;
        var list = bucket[hash];
        if(list != null && list.Count > 0){
            for(int i=0; i<list.Count; i++){
                if(list[i] == key){
                    list.RemoveAt(i);
                    count--;
                }
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public bool Contains(int key) {
        var hash = key % capacity;
        var list = bucket[hash];
        if(list != null && list.Count > 0){
            foreach(var item in list){
                if(item == key) return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */