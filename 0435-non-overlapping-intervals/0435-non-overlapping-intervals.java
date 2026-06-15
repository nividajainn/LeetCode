import java.util.*;

class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {

        // Sort intervals according to end time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        // End time of first interval
        int prevEnd = intervals[0][1];

        // Count of removed intervals
        int count = 0;

        // Traverse remaining intervals
        for(int i=1; i<intervals.length; i++){

            // Overlap exists
            if(intervals[i][0] < prevEnd){

                // Remove current interval
                count++;
            }
            // No overlap
            else{
                // Keep current interval
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}