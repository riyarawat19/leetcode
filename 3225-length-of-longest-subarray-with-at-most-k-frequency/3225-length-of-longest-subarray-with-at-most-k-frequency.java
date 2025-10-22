class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer,Integer>freq= new HashMap<>();
         int left=0;
         int maxLen=0;
          for(int right=0;right<nums.length;right++){
             freq.put(nums[right], freq.getOrDefault(nums[right],0)+1);

             // shrink window if any number exceedsk frequency
              while(freq.get(nums[right])>k){
                freq.put(nums[left],freq.get(nums[left])-1);
                left++;
              }
              maxLen=Math.max(maxLen,right-left+1);
          }
           return maxLen;
        
    }
}