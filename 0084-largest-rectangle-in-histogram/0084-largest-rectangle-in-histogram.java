class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] nse = nse(heights);
        int[] pse = pse(heights);

        for(int i=0; i<heights.length; i++){
            int width = nse[i]-pse[i]-1;
            int curr = heights[i]*width;
            maxArea = Math.max(maxArea, curr);
        }
        return maxArea;
    }

    static int[] pse(int[] height){
        int [] pse = new int[height.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<height.length; i++){

            while(!st.isEmpty() && height[st.peek()] >= height[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i] = -1;
            }
            else pse[i] = st.peek();

            st.push(i);
        }
        return pse;
    }

        static int[] nse(int[] height) {
        int[] nse = new int[height.length];
        Stack<Integer> st = new Stack<>();

        for (int i = height.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }

            if (st.isEmpty())
                nse[i] = height.length;
            else
                nse[i] = st.peek();

            st.push(i);
        }

        return nse;
    }
}