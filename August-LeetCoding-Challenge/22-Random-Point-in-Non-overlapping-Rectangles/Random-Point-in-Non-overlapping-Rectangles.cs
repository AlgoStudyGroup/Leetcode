public class Solution {
    private int[][] _solutionPoints;
    private SortedDictionary<int, int> _area = new SortedDictionary<int, int>();
    private int _numberOfSolutions = 0;
    private Random _random = new Random();
        
    public Solution(int[][] rects) {
        _solutionPoints = rects;
        for(int i=0; i<rects.Length; i++){
            var rect = rects[i];
            _numberOfSolutions += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            _area.Add(_numberOfSolutions, i);
        }
    }
    
    public int[] Pick() {
        var random = _random.Next(_numberOfSolutions) + 1;
        var index = _area.First(x => x.Key >= random).Value;
        return Pick(_solutionPoints[index]);
    }
    
    private int[] Pick(int[] rectangle){
        var x = _random.Next(rectangle[0], rectangle[2] + 1);
        var y = _random.Next(rectangle[1], rectangle[3] + 1);
        return new int[]{x , y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.Pick();
 */