public class Solution {
    public double AngleClock(int hour, int minutes) {
        var angle = Math.Abs((double)(hour + (double)minutes/60) / 12 * 360 - (double)minutes / 60 * 360);
        if(angle >= 180) angle = (double)360 - angle;
        return Math.Round(angle, 1);
    }
}