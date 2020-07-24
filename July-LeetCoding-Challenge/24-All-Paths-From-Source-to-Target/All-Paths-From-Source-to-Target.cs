public class Solution {
    public IList<IList<int>> AllPathsSourceTarget(int[][] graph) {
        var res = new List<IList<int>>();
        var path = new List<int>();
        path.Add(0);
        Dfs(graph, 0, res, path);        
        return res;
    }
    
    public void Dfs(int[][] graph, int node, List<IList<int>> res, List<int> path){
        if(node == graph.Length-1) {
            res.Add(new List<int>(path));
            return;
        }
        foreach(var n in graph[node]){
            path.Add(n);
            Dfs(graph, n, res, path);
            path.RemoveAt(path.Count()-1);
        }
    }
}