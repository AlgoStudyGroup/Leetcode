public class Solution {
    public int MinCostToMoveChips(int[] position) {
        int even = 0, odd = 0;
        for(int i=0; i<position.Length; i++){
            if(position[i] % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        
        return Math.Min(even, odd);        
    }
}
