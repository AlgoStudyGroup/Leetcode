class Solution {
public:
    double angleClock(int hour, int minutes) {
        double f1 = (hour % 12) * 30.0 + 0.5 * minutes;
        double f2 = 6.0 * minutes;
        double t = abs(f1 - f2);
        return min(t, 360 - t);
    }
};	