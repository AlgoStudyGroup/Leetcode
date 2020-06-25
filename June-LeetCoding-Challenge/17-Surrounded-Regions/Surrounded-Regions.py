class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board:
            for i in range(len(board)):
                if board[i][0]=='O':
                    self.bfs(board,i,0)
                if board[i][len(board[0])-1]=='O':
                    self.bfs(board,i,len(board[0])-1)
            for j in range(len(board[0])):
                if board[0][j]=='O':
                    self.bfs(board,0,j)
                if board[len(board)-1][j]=='O':
                    self.bfs(board,len(board)-1,j)  
            for i in range(len(board)):
                for j in range(len(board[0])):
                    if board[i][j]=='O':
                        board[i][j]='X'
                    if board[i][j]=='2':
                        board[i][j]='O'
        
    def bfs(self,board,i,j):
        q = [[i,j]]
        while q!=[]:
            pos = q.pop(0)
            a = pos[0]
            b = pos[1]
            board[a][b] = '2'
            if 0<=a+1<len(board):
                if board[a+1][b]=='O':
                    board[a+1][b]='2'
                    q.append([a+1,b])
            if 0<=a-1<len(board):
                if board[a-1][b]=='O':
                    board[a-1][b]='2'
                    q.append([a-1,b])
            if 0<=b+1<len(board[0]):
                if board[a][b+1]=='O':
                    board[a][b+1] = '2'
                    q.append([a,b+1])
            if 0<=b-1<len(board[0]):
                if board[a][b-1]=='O':
                    board[a][b-1] = '2'
                    q.append([a,b-1])
