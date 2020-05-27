/**
 * Use a hashMap to stock the index and the count, the count minus 1 if reach 0, plus 1 if reach 1.
 * We compare current length of contiguous array with the maxLength
 */
/**
 * Time complexity: O(n), because a signle loop of nums[]
 * Space complexity: O(n), becasue we build a HashMap
 */
class Solution {
    public int findMaxLength(final int[] nums) {
        int maxLength = 0;
        int count = 0;
        final Map<Integer, Integer> countsMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count -= 1;
            } else {
                count += 1;
            }
            
            /**
             * if the count is 0, it means that from the start of index, we have nothing added to the count，
             * So the length of contiguous array is from the starter to current index
             */
            if (count == 0) {
                maxLength = Math.max(maxLength, (i + 1));
            } else if (countsMap.containsKey(count)) {
                /**
                 * If the count is contained in the map, it means that for the index of contained count to 
                 * the current index, we have nothing added, we can build a contignous array, it's length is
                 * i minus index of contained count
                 */
                maxLength = Math.max(maxLength, i - countsMap.get(count));
            } else {
                countsMap.put(count, i);
            }
            
        }
        return maxLength;
    }
}