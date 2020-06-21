class Solution:
    
    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        a = len(dungeon)
        b = len(dungeon[0])
        dp = [[0 for x in range(b)] for y in range(a)]
        if dungeon[-1][-1]<=0:
            dp[-1][-1] = 1 - dungeon[-1][-1]
        else:
            dp[-1][-1] = 1
        for i in range(b-2,-1,-1):
            dp[-1][i] = max(1,dp[-1][i+1]-dungeon[-1][i])
        for j in range(a-2,-1,-1):
            dp[j][-1] = max(1,dp[j+1][-1]-dungeon[j][-1])
        for i in range(a-2,-1,-1):
            for j in range(b-2,-1,-1):
                dp[i][j] = max(1,min(dp[i+1][j],dp[i][j+1])-dungeon[i][j])
        return dp[0][0]
