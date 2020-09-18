public class Solution {
    public bool IsRobotBounded(string instructions) {
        int x = 0;
        int y = 0;
        var dirs = new int[4][]{new int[]{0,1}, new int[]{1, 0}, new int[]{0,-1}, new int[]{-1,0}};
        int d = 0;
        
        foreach(char c in instructions){
            if(c == 'L'){
                d = (d+3)%4;
            }else if(c == 'R'){
                d = (d+1)%4;
            }else{
                x += dirs[d][0];
                y += dirs[d][1];
            }
        }
        
        return x == 0 && y == 0 || d > 0;
    }
}