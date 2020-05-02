/* The isBadVersion API is defined in the parent class VersionControl.
      bool IsBadVersion(int version); */

public class Solution : VersionControl {

  public int FirstBadVersion(int n) {
		int left = 1;
		int right = n;
		while (left < right) {
			int mid = left + (right - left) /2;
			if (IsBadVersion(mid)){
				right = mid;
			}
			else 
			{
				left = mid + 1;
			}
		}
		return left;        
	}
   }
