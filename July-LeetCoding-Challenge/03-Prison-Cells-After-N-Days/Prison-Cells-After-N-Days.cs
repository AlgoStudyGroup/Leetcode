public class Solution {
    public int[] PrisonAfterNDays(int[] cells, int N) {
        var length = cells.Length;
        var startCells = new int[length];
        var runningCells = new int[length];       
        for(int i=0; N-->0; cells=runningCells.ToArray(), ++i){
            for(int x=1; x<length-1; x++){
                runningCells[x] = (cells[x-1] == cells[x+1]) ? 1 : 0;
            }
            if(i==0) {
                startCells = runningCells.ToArray();
            }
            else if(startCells.SequenceEqual(runningCells)){
                N %= i;
            }
        }
        return runningCells;
    }
}