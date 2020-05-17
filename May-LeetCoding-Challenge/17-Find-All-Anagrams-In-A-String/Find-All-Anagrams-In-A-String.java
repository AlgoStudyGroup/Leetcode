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