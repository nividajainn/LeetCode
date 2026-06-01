class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int totalCost = 0;
        
        // Traverse from most expensive candy
        for(int i= cost.length-1; i>=0; i -= 3){
            
            // Pay for the most expensive candy
            totalCost += cost[i];
          
        // Pay for the second most expensive candy if it exists  
            if(i-1 >= 0){
                totalCost += cost[i-1];
            }

            // Skip the third candy (free)
        }

        return totalCost;
    }
}