class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:        
	sl = len(s)
        droite,taille = len(p),len(p)
        if(sl<droite):
            return []
        res = []
        window = dict()
        need = dict()
        for c in p: 
            need[c] = need.get(c, 0) + 1
        tmp = s[0]
        gauche = 0
        droite = gauche+taille
        for c in s[:droite]:
            window[c] = window.get(c,0)+1
        if(window==need):
            res.append(0)
        while(droite<sl):
            debut = s[gauche]
            value = window.get(debut)
            if(value<=1):
                del window[debut]
            else:
                window[debut]-=1
            tmp = s[droite]
            #print("tmp = ",tmp)
            if(tmp not in need):
                window.clear()
                gauche+=1
                droite = gauche+taille
                for c in s[gauche:droite]:
                    window[c]=window.get(c,0)+1
            else:
                window[tmp] = window.get(tmp,0)+1 
                gauche+=1
                droite = gauche+taille    
            if(window==need):
                res.append(gauche)
        return res
