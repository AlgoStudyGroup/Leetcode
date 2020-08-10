class Solution:
    
    def __init__(self):
        self.res = 0
        
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = []
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==2:
                    q.append([i,j])
        self.bfs(grid,q)                    
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    return -1
        return self.res
                
    def bfs(self,grid,q):
        while q!=[]:
            l = []
            while q!=[]:
                l.append(q.pop(0))
            for tmp in l:
                a,b = tmp[0],tmp[1]
                length = len(q)
                if a+1<len(grid):
                    if grid[a+1][b]==1:
                        grid[a+1][b]=2
                        q.append([a+1,b])
                if a-1>=0:
                    if grid[a-1][b]==1:
                        grid[a-1][b]=2
                        q.append([a-1,b])
                if b+1<len(grid[0]):
                    if grid[a][b+1]==1:
                        grid[a][b+1]=2
                        q.append([a,b+1])
                if b-1>=0:
                    if grid[a][b-1]==1:
                        grid[a][b-1]=2
                        q.append([a,b-1])
            if len(q) > 0:
                self.res+=1
