class Solution:
    def findComplement(self, num: int) -> int:
        bit = 0
        count = 0
        while num!=0:
            if num&1==0:
                bit+=(1<<count)            
            num>>=1
            count+=1
        return bit
