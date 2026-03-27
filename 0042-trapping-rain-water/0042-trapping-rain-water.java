class Solution {
    public int trap(int[] height) {

        // left pointer start se, right pointer end se
        int left = 0, right = height.length - 1;

        // left side ka max height aur right side ka max height
        int leftMax = 0, rightMax = 0;

        // total trapped water
        int water = 0;

        // jab tak pointers cross nahi karte
        while (left < right) {

            // jo side chhoti hai usko process karte hain
            if (height[left] < height[right]) {

                // agar current height >= leftMax
                // to new leftMax banega
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // warna water store hoga
                    // formula: leftMax - current height
                    water += leftMax - height[left];
                }

                // left pointer aage badhao
                left++;

            } else {

                // same logic right side ke liye
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // water store hoga
                    water += rightMax - height[right];
                }

                // right pointer peeche lao
                right--;
            }
        }

        // final answer return
        return water;
    }
}