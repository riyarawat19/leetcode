class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
         Map<String,Integer>Map= new HashMap<>();
         // store rows in map
         for(int[] row:grid){
             String key= Arrays.toString(row); //[3,2,1]
 Map.put(key,Map.getOrDefault(key,0)+1);

         }
        
         int count =0;
         // compare each column with rows
         for(int c=0 ; c<n ;c++){
            int[] col= new int[n];
             for(int r=0;r<n;r++){
                 col[r]= grid[r][c];

             }
             String key = Arrays.toString(col);
            count += Map.getOrDefault(key, 0);
        }

        return count;
    
    }
}