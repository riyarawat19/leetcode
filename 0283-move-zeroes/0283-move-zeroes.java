class Solution {
    public void moveZeroes(int[] nums) {
//          int count=0;
//          for(int i=0;i<nums.length;i++){
//             if(nums[i]!=0){
//                 nums[count++]=nums[i];   //increase count if it is nonzero

//             }
//          }
//          while( count<nums.length){
//             nums[count++]=0;
//          }
//     }
// }

 int j = -1;
        //place the pointer j: in the starting
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {   
                j = i;
                break;
            }
        }
          if (j == -1) return;// if nozero
            // Step 2: Iterate from the element after j
        for (int i = j + 1; i < nums.length; i++) {
            // When we find a non-zero, swap it with nums[j]
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++; // move j to the next zero
            }
        }
    }
}