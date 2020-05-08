class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        if(coordinates[1][0]^coordinates[0][0])==0:
            return len(set([x[0] for x in coordinates]))^1==0
        else:
            k = (coordinates[1][1]-coordinates[0][1])/(coordinates[1][0] - coordinates[0][0])
            for i in range(1,len(coordinates)-1):
                if (coordinates[i+1][0] - coordinates[i][0])^0==0:
                    return False
                k1 = (coordinates[i+1][1]-coordinates[i][1])/(coordinates[i+1][0] - coordinates[i][0])
                #print(coordinates[i],k,k1)
                if(k!=k1):
                    return False
            return True
