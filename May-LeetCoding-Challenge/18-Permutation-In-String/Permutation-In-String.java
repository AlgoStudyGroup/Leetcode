class Solution {
    private boolean checkDiff(int[] diff) {
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] != 0) return false;
        }
        
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        if(s2Length < s1Length || s2 == null) return false;
        
        int[] diff = new int[26];
        for (int i = 0; i < s1Length; i++) {
            diff[s1.charAt(i) - 'a']--;
            diff[s2.charAt(i) - 'a']++;
        }
        
        if (checkDiff(diff)) return true;
        
        for (int i = s1Length; i < s2Length; i++) {
            diff[s2.charAt(i) - 'a']++;
            diff[s2.charAt(i-s1Length) - 'a']--;
            if (checkDiff(diff)) return true;
        }
        
        return false;
    }
}