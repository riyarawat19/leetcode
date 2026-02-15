class Solution {
    public int[] nextGreaterElements(int[] nums) {
     int n= nums.length;
     int[] result= new int[n];
    Arrays.fill(result,-1);
     Stack<Integer>stack= new Stack<>();


      for(int i=0 ;i<2*n;i++){ // [1,2,1] becomes [1,2,1,1,2,1]
         int num = nums[i%n]; 
         while(!stack.isEmpty() && nums[stack.peek()]<num){
            result[stack.pop()]=num;
         }
         if(i<n){
            stack.push(i);
         }
      }
       return result;
    }
}
//1,2,1
// 1 push then 2 push but 2 is greater than 1 then pop 1 
// and push 2  then push 1
// simply it pushes like 1,2
      //current element is greater stack k top m
       // pop
       //otherwise nrml push in stack...1,2