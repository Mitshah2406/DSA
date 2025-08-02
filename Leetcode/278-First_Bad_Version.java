/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    /* 
     We are given a function isBadVersion(version) that returns true if the version is bad.

     Approach:
     - If isBadVersion(mid) returns true, it means this version is bad. 
       However, we are not yet certain if it is the *first* bad version, 
       so we continue searching in the left half (towards earlier versions).
     
     - If isBadVersion(mid) returns false, it means this version is good. 
       Therefore, the first bad version must be in the right half (later versions).

     Binary Search Logic:
     - Initially, 'low' points to a definitely good version (or start), 
       and 'high' points to a definitely bad version (or end).
     - We keep narrowing the search space until low surpasses high.

     Final Answer:
     - After the loop, 'low' will point to the first bad version because 
       it represents the smallest index where badness starts.

     Time Complexity:
     - O(log n), since we halve the search space in each iteration.
    */
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (super.isBadVersion(mid)) {
                high = mid - 1;  // Search earlier versions
            } else {
                low = mid + 1;   // Search later versions
            }
        }

        return low;
    }
}
