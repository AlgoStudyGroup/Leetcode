class CombinationIterator:

    def __init__(self, characters: str, combinationLength: int):
        self.res = []
        if combinationLength==1:
            self.res = [x for x in characters]
        else:
            self.bk([],characters,combinationLength)
        
        
    def bk(self,cur,choice,fin):
        if len(cur) == fin:
            self.res.append("".join(cur))
            return
        for i in range(len(choice)):
            cur.append(choice[i])
            self.bk(cur,choice[i+1:],fin)
            cur.pop(-1)
        return 
        

    def next(self) -> str:
        tmp = self.res[0]
        self.res.pop(0)
        return tmp

    def hasNext(self) -> bool:
        return self.res!=[]

