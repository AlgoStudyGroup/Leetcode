class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length <= 2) return true;
        
        float slope = getSlope(coordinates[0], coordinates[1]);
        float newSlope = 0;
        
        for (int i = 2; i < coordinates.length; i++) {
            newSlope = getSlope(coordinates[0], coordinates[i]);
            
            if(newSlope != slope) return false;
        }
        
        return true;
    }
    
    private float getSlope(int[] p1, int[] p2) {
        if(p2[0] - p1[0] == 0) return 0;
        return (float)(p2[1] - p1[1]) / (p2[0] - p1[0]);
    }
}