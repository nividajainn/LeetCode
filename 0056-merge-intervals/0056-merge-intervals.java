class Solution {
    public int[][] merge(int[][] intervals) {

        // Intervals ko start time ke basis par sort karo
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Merged intervals store karne ke liye list
        List<int[]> ans = new ArrayList<>();

        // Pehla interval current interval maan lo
        int start = intervals[0][0];
        int end = intervals[0][1];

        // Baaki intervals traverse karo
        for (int i = 1; i < intervals.length; i++) {

            // Agar overlap hai
            if (intervals[i][0] <= end) {

                // End ko maximum tak extend kar do
                end = Math.max(end, intervals[i][1]);
            }

            // Agar overlap nahi hai
            else {

                // Current merged interval answer me add karo
                ans.add(new int[]{start, end});

                // Naya interval current bana do
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Last interval add karna mat bhoolna
        ans.add(new int[]{start, end});

        // List ko 2D array me convert karke return karo
        return ans.toArray(new int[ans.size()][]);
    }
}