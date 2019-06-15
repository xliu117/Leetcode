/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

//oooxxx
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(isBadVersion(0)) return 0;
        
       
        
        int hi = n;
        int lo = 0;
        
        while(lo+1 < hi){
            int mid = lo + (hi - lo)/2;
            if(isBadVersion(mid)){
                hi = mid;
            }else{
                lo = mid;
            }
        }
        
        return isBadVersion(lo)? lo: hi;
    }
}
