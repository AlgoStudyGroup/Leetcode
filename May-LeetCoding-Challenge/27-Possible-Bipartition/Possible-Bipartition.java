import java.util.HashMap;

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        /**
         * Build a graph, try to color each node
         * 0, If the node hasn't been colored, => color to 1
         * 1, color its dislikes nodes to - color => color to -1
         * 2, conflct return false
         */
        
        Map<Integer, Set<Integer>> g = new HashMap<>();

        // build graph
        for (int[] d : dislikes) {
            int a = d[0];
            int b = d[1];
            g.putIfAbsent(a, new HashSet<Integer>());
            g.putIfAbsent(b, new HashSet<Integer>());
            g.get(a).add(b);
            g.get(b).add(a);
        }

        int[] colors = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            // the node is not colored and there is a conflict
            if (colors[i] == 0 && !dfs(colors, 1, i, g)) return false;
        }

        return true;
    }

    private boolean dfs (int[] colors, int color, int node, Map<Integer, Set<Integer>> g) {
        // The node is already colored
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;
        if (g.get(node) == null) return true;
        for (int next : g.get(node)) {
            if (!dfs(colors, -color, next, g)) return false;
        }

        return true;
    }
}