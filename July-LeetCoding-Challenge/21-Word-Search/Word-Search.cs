public class Solution {
    public bool Exist(char[][] board, string word) {
        var arr = word.ToCharArray();
        for(int i=0; i<board.Length; i++){
            for(int j=0; j<board[0].Length; j++){
                if(Dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private bool Dfs(char[][] board, string word, int x, int y, int idx){
        if(idx == word.Length) return true;
        
        if(x < 0 || x == board.Length || y < 0 || y == board[0].Length)
            return false;
        
        if(board[x][y] != word[idx]) return false;
        
        board[x][y] = (char)(board[x][y] ^ 256);
        var exist = Dfs(board, word, x-1, y, idx+1) || Dfs(board, word, x+1, y, idx+1)
            || Dfs(board, word, x, y-1, idx+1) || Dfs(board, word, x, y+1, idx+1);
        board[x][y] = (char)(board[x][y] ^ 256);
        
        return exist;
    }
}