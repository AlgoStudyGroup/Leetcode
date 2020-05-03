class Solution1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null){
            return false;
        }
        
        if(ransomNote.length() > magazine.length()) {
            return false;
        }
        
        // Linked List solution
        List<Character> magazineLinkedList = new LinkedList<>();
        for(int i = 0; i < magazine.length(); i++) {
            magazineLinkedList.add(magazine.charAt(i));
        }
        
        Character tmp;
        for(int i = 0; i < ransomNote.length(); i++) {
            tmp = ransomNote.charAt(i);
            if(magazineLinkedList.contains(tmp)) {
                // will remove the first occurrence of tmp
                magazineLinkedList.remove(tmp);
            } else {
                return false;
            }
        }
        
        return true;
    }
}

class Solution2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null){
            return false;
        }
        
        if(ransomNote.length() > magazine.length()) {
            return false;
        }
        
        Character tmp;
        for(int i = 0; i < ransomNote.length(); i++) {
            tmp = ransomNote.charAt(i);
            if(magazine.indexOf(tmp) != -1) {
                magazine = magazine.replaceFirst(tmp.toString(), "\0");
            } else {
                return false;
            }
        }
        
        return true;
    }
}

class Solution3 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> letters = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            int count = letters.getOrDefault(c, 0) + 1;
            letters.put(c, count);
        }
        for (char c : ransomNote.toCharArray()) {
            int count = letters.getOrDefault(c, 0) - 1;
            if (count < 0) {
                return false;
            }
            letters.put(c, count);
        }
        return true;
    }
}

class Solution4 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[128]; // ASCII table: 128 characters
        for (char c : magazine.toCharArray()) {
            letters[c]++;
        }
        for (char c : ransomNote.toCharArray()) {
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
