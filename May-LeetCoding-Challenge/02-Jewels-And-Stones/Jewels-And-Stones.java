class Solution {
	
    public int numJewelsInStones(String J, String S) {
        if (J == null || S==null) return 0;
        Set<Character> jmap = new HashSet<>();
        //time O(len of J)
        //space O(len of J)
        for (int i = 0; i<J.length(); i++){
            jmap.add(J.charAt(i));
        }
        
        //time O(len of S)
        int count = 0;
        for(int i = 0; i<S.length(); i++){
            if(jmap.contains(S.charAt(i))) count++;
        }
        return count;
    }
}