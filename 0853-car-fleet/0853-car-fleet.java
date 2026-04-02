class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // pair bana rahe hain: [position, time to reach target]
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // cars ko position ke according sort karo
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        int fleets = 0;
        double maxTime = 0;

        // right se left traverse karo
        for (int i = n - 1; i >= 0; i--) {
            double currTime = cars[i][1];

            // agar current car ko zyada time lag raha hai,
            // to ye nayi fleet banayegi
            if (currTime > maxTime) {
                fleets++;
                maxTime = currTime;
            }
        }

        return fleets;
    }
}