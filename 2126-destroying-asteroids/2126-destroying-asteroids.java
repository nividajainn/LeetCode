class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        // Sort asteroids in ascending order
        Arrays.sort(asteroids);

        // Use long to avoid integer overflow
        long currMass = mass;

        // Try to destroy asteroids one by one
        for (int asteroid : asteroids) {

            // Cannot destroy if asteroid is larger than current mass
            if (currMass < asteroid) {
                return false;
            }

            // Destroy asteroid and gain its mass
            currMass += asteroid;
        }

        // All asteroids destroyed successfully
        return true;
    }
}