public class Solution {
	
	//Better solution
	//Runtime: 72 ms, faster than 99.58% of C# online submissions for First Unique Character in a String.
	//Memory Usage: 31.9 MB, less than 69.64% of C# online submissions for First Unique Character in a String.
    public int FirstUniqChar(string s) {
        var arr = new int[26];
        
        //array's index means character, 0 to 25 means 'a' to 'z'
        //array's value means number of occurrence
        foreach(var c in s){
            arr[c - 'a']++;
        }
                
        for(int i=0; i<s.Length; i++){
            if(arr[s[i]-'a'] == 1){
                return i;
            }
        }
        
        return -1;        
    }
    
	//Brutal solution with Tuple
	//Runtime: 132 ms, faster than 31.44% of C# online submissions for First Unique Character in a String.
	//Memory Usage: 36 MB, less than 5.98% of C# online submissions for First Unique Character in a String.
	public int FirstUniqChar(string s) {
        //Tuple's Item1 means char's position, Item2 means char's number of occurence
        var dict = new Dictionary<char, Tuple<int, int>>();
        var chars = s.ToCharArray();
        
        for(int i=0; i<chars.Length; i++){
            if(!dict.ContainsKey(chars[i])){
                dict.Add(chars[i], new Tuple<int, int>(i, 1));
            }else{
                var st = dict[chars[i]];
                var newSt = new Tuple<int, int>(st.Item1, st.Item2+1);
                dict[chars[i]] = newSt;
            }
        }
        
        foreach(var kv in dict){
            if(kv.Value.Item2 == 1){
                return kv.Value.Item1;
            }
        }
        
        return -1;
    }
    
}