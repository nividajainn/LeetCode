class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        ans = Math.min(ans,
                solve(landStartTime, landDuration,
                      waterStartTime, waterDuration));

        ans = Math.min(ans,
                solve(waterStartTime, waterDuration,
                      landStartTime, landDuration));

        return ans;
    }

    private int solve(int[] startA, int[] durA,
                      int[] startB, int[] durB) {

        int n = startB.length;

        int[][] rides = new int[n][2];

        for (int i = 0; i < n; i++) {
            rides[i][0] = startB[i];
            rides[i][1] = durB[i];
        }

        Arrays.sort(rides, (a, b) -> a[0] - b[0]);

        int[] start = new int[n];
        int[] duration = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = rides[i][0];
            duration[i] = rides[i][1];
        }

        // Prefix minimum duration
        int[] prefixMinDur = new int[n];
        prefixMinDur[0] = duration[0];

        for (int i = 1; i < n; i++) {
            prefixMinDur[i] =
                    Math.min(prefixMinDur[i - 1], duration[i]);
        }

        // Suffix minimum(start + duration)
        int[] suffixMin = new int[n];

        suffixMin[n - 1] =
                start[n - 1] + duration[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(
                    suffixMin[i + 1],
                    start[i] + duration[i]
            );
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < startA.length; i++) {

            int finish = startA[i] + durA[i];

            int idx = upperBound(start, finish);

            // Rides already open
            if (idx > 0) {
                ans = Math.min(
                        ans,
                        finish + prefixMinDur[idx - 1]
                );
            }

            // Rides opening later
            if (idx < n) {
                ans = Math.min(
                        ans,
                        suffixMin[idx]
                );
            }
        }

        return ans;
    }

    private int upperBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}