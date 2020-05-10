# Solution 1 Using HashTable
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        trusting = set([x[0] for x in trust])
        candidat = set([x for x in range(1,N+1)])-trusting # Those who don't trust anyone
        if not candidat: # If everyone trust at least one person, return -1
            return -1
        croire = dict() # counting persons that each trusts
        for x in trust:
            #print(x[0],x[1])
            if x[0] not in croire:
                croire[x[0]] = set([x[1]])
            else:
                croire[x[0]].add(x[1])
        for x in trusting: # find those who are trusted by everyone
            candidat &= croire[x]
        if not candidat or len(candidat)>1: # 
            return -1
        else:             # if and only if one person
            return candidat.pop()
