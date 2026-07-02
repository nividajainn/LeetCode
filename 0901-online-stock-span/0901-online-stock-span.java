class StockSpanner {

   // Stack stores {price, span}
    Stack<Integer> st;
    HashMap<Integer, Integer> map; 

    // Constructor
    public StockSpanner() {
        st = new Stack<>();
        map = new HashMap<>();
    } 

    public int next(int price) {

        int span = 1;

        while (!st.isEmpty() && st.peek() <= price) {

            span += map.get(st.peek()); // Get span from HashMap
            st.pop();
        }

        st.push(price);
        map.put(price, span);

        return span;
    
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */