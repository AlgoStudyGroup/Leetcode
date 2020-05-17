/*
* Use a int[26] to store char count, 
* compare between p count and each s substring count.
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() - p.length() < 0) {
            return res;
        }
        int[] pCount = transform(p.toCharArray(), 0, p.length());
        char[] sArray = s.toCharArray();
        int[] strCount = transform(sArray, 0, p.length());
        if (Arrays.equals(strCount, pCount)) 
            res.add(0);
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (moveAndCompare(sArray, strCount, i, i + p.length(), pCount))
                res.add(i + 1);
        }
        return res;
    }
    
    public int[] transform(char[] s, int begin, int end) {
        int[] count = new int[26];
        for (int i = begin; i < end; i++) {
            char c = s[i];
            int idx = c - 'a';
            count[idx] += 1;
        }
        return count;
    }
    
    public boolean moveAndCompare(char[] str, int[] strCount, int toRemove, int toAdd, int[] pCount) {
        int toRemoveIdx = str[toRemove] - 'a';
        strCount[toRemoveIdx] -= 1;
        int toAddIdx = str[toAdd] - 'a';
        strCount[toAddIdx] += 1;
        return Arrays.equals(strCount, pCount);
    }
}

class Solution2 {    
    boolean isAnagram (String a, String b) {
        int[] arrayA = new int[26];
        int[] arrayB = new int[26];

        for (int i = 0; i < a.length(); i++) {
            arrayA[a.charAt(i) - 'a']++;
        }

        for (int j = 0; j < b.length(); j++) {
            arrayB[b.charAt(j) - 'a']++;
        }
        
        for (int k = 0; k < 26; k++) {
            if(arrayA[k] != arrayB[k])  return false;
        }
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        //List<String> listSubString = new ArrayList<>();
        String subString = null;
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            subString = s.substring(i, p.length() + i);
             if(isAnagram(subString, p)) res.add(i);
        }
        
        return res;
    }
}