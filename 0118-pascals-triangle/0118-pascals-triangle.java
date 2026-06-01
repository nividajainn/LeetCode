class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
          
        for(int i=0; i<numRows; i++){
          
          // Current row
          List<Integer> row = new ArrayList<>();
           
            for(int j=0; j<=i; j++){  // Fill elements of current row

                // First and last elements are always 1
                if(j == 0 || j == i){
                    row.add(1);
                }
                
                 // Middle element = sum of two elements above it
                else{
                    row.add(
                    result.get(i-1).get(j-1)
                    + result.get(i-1).get(j)
                    );
                }
            }

            result.add(row); // Add current row to answer
        }

        return result;
    }
}