public class Solution {
    public int CanCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0, sumCost = 0, tank = 0, pos = 0;
        
        for(int i = 0; i<gas.Length; i++){
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0){
                pos = i+1;
                tank = 0;
            }
        }
        
        if(sumGas >= sumCost){
            return pos;
        }
        
        return -1;
    }
}