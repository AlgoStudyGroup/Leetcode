public class Solution
{

    public IList<string> FindWords(char[][] board, string[] words)
    {
        var res = new List<string>();
        var root = BuildTrie(words);
        for (var i = 0; i < board.Length; i++)
        {
            for (var j = 0; j < board[0].Length; j++)
            {
                Dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void Dfs(char[][] board, int x, int y, Trie node, List<string> res)
    {
        var c = board[x][y];
        if (c == '#' || node.Next[c - 'a'] == null)
        {
            return;
        }
        node = node.Next[c - 'a'];
        if (node.Word != null)
        {
            res.Add(node.Word);
            node.Word = null;
        }

        board[x][y] = '#';
        if (x > 0) Dfs(board, x - 1, y, node, res);
        if (y > 0) Dfs(board, x, y - 1, node, res);
        if (x < board.Length - 1) Dfs(board, x + 1, y, node, res);
        if (y < board[0].Length - 1) Dfs(board, x, y + 1, node, res);
        board[x][y] = c;
    }

    public Trie BuildTrie(string[] words)
    {
        var trie = new Trie();
        foreach (string word in words)
        {
            var node = trie;
            foreach (char c in word)
            {
                int i = c - 'a';
                if (node.Next[i] == null)
                {
                    node.Next[i] = new Trie();
                }
                node = node.Next[i];
            }
            node.Word = word;
        }
        return trie;
    }
}

public class Trie
{
    public string Word { get; set; }
    public Trie[] Next = new Trie[26];
}