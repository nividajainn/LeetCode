class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1], a[1]));
        
        int units = 0;

        for(int i=0; i<boxTypes.length; i++){
            int box = boxTypes[i][0];
            int unitperbox = boxTypes[i][1];

            if(truckSize >= box){
              units += box * unitperbox;

              truckSize -= box;
            }
            else{
                units += truckSize * unitperbox;

                break;
            }
        }
        return units;
    }
}