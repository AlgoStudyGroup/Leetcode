public class Solution {
    public int LeastInterval(char[] tasks, int n) {
        var counter = new int[26];
        //The maximum frequency of all chars
        var maxFrequency = 0;
        //The number of char which have the maximum frequency
        var numberOfCharsWithMaxFrequency = 0;
        foreach(char c in tasks){
            counter[c - 'A']++;
            if(maxFrequency == counter[c - 'A']){
                numberOfCharsWithMaxFrequency++;
            }else if(maxFrequency < counter[c - 'A']){
                maxFrequency = counter[c - 'A'];
                numberOfCharsWithMaxFrequency = 1;
            }
        }
        
        //Number of parts splitted by maximum frequencied char
        var numberOfParts = maxFrequency - 1;
        //Length of splitted part, it could be maximum = n, minumum = 0
        var partLength = n - (numberOfCharsWithMaxFrequency - 1);
        //Total empty slots between maximum frenquent chars
        var emptySlots = numberOfParts * partLength;
        var availableChars = tasks.Length - maxFrequency * numberOfCharsWithMaxFrequency;
        var idles = Math.Max(0, emptySlots - availableChars);
        
        return tasks.Length + idles;
    }
}
