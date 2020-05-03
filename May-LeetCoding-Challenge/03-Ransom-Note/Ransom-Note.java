class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null){
            return false;
        }
        
        if(ransomNote.length() > magazine.length()) {
            return false;
        }
        /*
        // String solution
        Character tmp;
        for(int i = 0; i < ransomNote.length(); i++) {
            tmp = ransomNote.charAt(i);
            if(magazine.indexOf(tmp) != -1) {
                magazine = magazine.replaceFirst(tmp.toString(), "\0");
            } else {
                return false;
            }
        }
        */
        
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