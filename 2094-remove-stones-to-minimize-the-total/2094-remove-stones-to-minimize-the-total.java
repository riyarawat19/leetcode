class Solution {
    public int minStoneSum(int[] piles, int k) {
        int n=piles.length;
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        int sum=0;
        for(int i=0;i<n; i++){
            pq.add(piles[i]);
            sum+=piles[i];       // All piles are inserted into the max heap.

// sum becomes the total number of stones initially.
        }
        for(int i=1;i<=k;i++){

            int maxEle=pq.poll();  //top me largest 
           
            int remove=maxEle/2;
            sum-=remove;    // sum jo remove hua
            maxEle-= remove;

            pq.add(maxEle);
        }
        return sum;
    }
}