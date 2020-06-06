class Solution1:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if len(people)<=1:
            return people
        people.sort(reverse=True)
        queue = []
        tmp = [people[0]]
        for i in range(1,len(people)):
            if people[i-1][0]==people[i][0]:
                tmp.append(people[i])
            else:
                queue+=sorted(tmp)
                tmp = [people[i]]
        queue+=sorted(tmp)
        res = [queue[0]]
        i = 1
        while queue[i][0]==queue[0][0] and i<len(queue):
            res.append(queue[i])
            i+=1
        while i<len(queue):
            res.insert(queue[i][1],queue[i])
            i+=1
        return res
