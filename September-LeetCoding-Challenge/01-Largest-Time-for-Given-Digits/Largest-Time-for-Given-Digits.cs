public class Solution {
    public string LargestTimeFromDigits(int[] A) {
        var l = new Queue<string>();
        l.Enqueue("");
        
        for(int n=0; n<A.Length; n++){
            for(int size = l.Count; size>0; size--){
                var s = l.Dequeue();
                for(int i=0; i<=s.Length; i++){
                    l.Enqueue(s.Substring(0,i) + A[n] + s.Substring(i));
                }
            }
        }
        
        var largest = "";
        foreach(var s in l){
            var t = s.Substring(0, 2) + ":" + s.Substring(2);
            if(t[3] < '6' && t.CompareTo("24:00") <0 && t.CompareTo(largest)>0){
                largest = t;
            }
        }
        
        return largest;
    }
}
