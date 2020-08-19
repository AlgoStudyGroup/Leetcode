public class Solution {
    public string ToGoatLatin(string S) {
        var arr = S.Split(" ");
        var vowels = new Dictionary<char, int>(){ 
            {'a', 0}, {'e', 0}, {'i', 0}, {'o', 0}, {'u', 0},
            {'A', 0}, {'E', 0}, {'I', 0}, {'O', 0}, {'U', 0}};

        var sb = new StringBuilder();
        var count = 1;
        foreach(var item in arr){
            var t = new StringBuilder();
            if(vowels.ContainsKey(item[0])){
                t.Append(item);
                t.Append("ma");
            }else{
                if(item.Length>1){
                    for(int i=1; i<item.Length; i++){
                        t.Append(item[i]);
                    }
                }
                t.Append(item[0]);
                t.Append("ma");
            }
            t.Append('a', count);
            sb.Append(t + " ");
            count++;
        }
        return sb.ToString().Trim();
    }
}
