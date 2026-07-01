class StockSpanner {

   // Stack stores {price, span}
    Stack<int[]> st;

    // Constructor
    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {

        // Every new price has at least a span of 1 (today itself)
        int span = 1;

        // Remove all previous prices that are
        // less than or equal to the current price
        while (!st.isEmpty() && st.peek()[0] <= price) {

            // Add the span of the popped price
            span += st.peek()[1];

            // Remove it from the stack
            st.pop();
        }

        // Push current price and its calculated span
        st.push(new int[]{price, span});

        // Return today's span
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */