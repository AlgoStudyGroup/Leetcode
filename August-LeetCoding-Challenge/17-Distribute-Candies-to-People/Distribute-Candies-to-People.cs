public class Solution {
    public int[] DistributeCandies(int candies, int num_people) {
        if(candies == 0 || num_people == 0) return new int[num_people];
        var res = new int[num_people];
        var numberOfTours = 0;
        var tourIncrement = num_people * num_people;
        var tourFixValues = (num_people * (num_people +1))/2;
        var usedCandies = tourFixValues;
        while(candies - usedCandies >= 0){
            candies -= usedCandies;
            numberOfTours++;
            usedCandies = tourFixValues + tourIncrement*numberOfTours;
        }
        
        if(numberOfTours > 0){
            for (int i = 0; i < num_people; i++) {
                res[i] = num_people * (numberOfTours * (numberOfTours - 1)) / 2 +  (i + 1) * numberOfTours;
            }
        }
        
        var offset = numberOfTours * num_people +1;
        for(int i=0; i<num_people && candies>0; i++){
            res[i] += Math.Min(candies, offset);
            candies -= offset;
            offset++;
        }
        
        return res;
    }
}
