public class Solution {
    public int OrangesRotting(int[][] grid) {
        if(grid == null || grid.Length == 0) return 0;
        var rows = grid.Length;
        var cols = grid[0].Length;
        var count_fresh = 0;
        Queue<int[]> queue = new Queue<int[]>();
        //Push rotten oranges in the queue, count fresh oranges
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] ==2){
                    queue.Enqueue(new int[2]{i, j});
                }else if(grid[i][j] ==1){
                    count_fresh++;
                }
            }
        }
        
        if(count_fresh == 0) return 0;
        
        var count = 0;
        var dirs = new int[4][]{new int[]{1,0}, new int[]{-1,0}, new int[]{0,-1}, new int[]{0,1}};
        while(queue.Count > 0){
            count++;
            var size = queue.Count;
            for(int i=0; i<size; i++){
                var point = queue.Dequeue();
                foreach(int[] dir in dirs){
                    var x = point[0] + dir[0];
                    var y = point[1] + dir[1];
                    if(x<0 || y<0 || x>=rows || y>=cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    
                    grid[x][y] =2;
                    queue.Enqueue(new int[2]{x, y});
                    count_fresh--;
                }
            }
        }
        return count_fresh == 0 ? count-1 : -1;
    }
}
