public class Helper {
    public int a;
    public int b;
    public int diff {get {return b-a;}}
}

public class Solution {
    public int TwoCitySchedCost(int[][] costs) {
        var helpers = new List<Helper>();
        for(int i = 0; i < costs.Length; i++)
        {
            helpers.Add(new Helper(){
                a = costs[i][0],
                b = costs[i][1],
            });
        }
        helpers = helpers.OrderBy(h => h.diff ).ToList();
        
        int result = 0;
        for(int i = 0; i < helpers.Count; i++)
        {
            var helper = helpers[i];
            result += i < helpers.Count/2 ? helper.b : helper.a;
        }
        return result;
    }
}
