public class Solution {
    public int FindMaximumXOR(int[] nums) {
        int max = 0, mask=0;
        for(int i=31; i>=0; i--){
            mask |= (1 << i);
            
            var hs = new HashSet<int>();
            foreach(int num in nums){
                hs.Add(num & mask);
            }
            
            int tmp = max | (1 << i);
            foreach(int prefix in hs){
                if(hs.Contains(tmp ^ prefix)){
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
