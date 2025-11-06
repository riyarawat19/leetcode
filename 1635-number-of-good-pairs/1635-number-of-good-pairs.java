 class Solution {
//     public int numIdenticalPairs(int[] nums) {
//         int count = 0;
//         int n = nums.length;
        
//         for (int i = 0; i < n - 1; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (nums[i] == nums[j]) {
//                     count++;
//                 }
//             }
//         }
        
//         return count;
//     }
// }
public  int numIdenticalPairs(int[] nums) {

Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

    int count = 0;
    for (int f : freq.values()) {
        count += f * (f - 1) / 2;
    }
    return count;
}
 }