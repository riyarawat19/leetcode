class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
          int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {// ryt to left
        int maxVal = 0;   // highest number in current group
int best = 0;
for (int len = 1; len <= k && i + len <= n; len++) {
         maxVal = Math.max(maxVal, arr[i + len - 1]);
                best = Math.max(best, maxVal * len + dp[i + len]);
            }

            dp[i] = best;
        }

        return dp[0];
    }
} //ensures we don't go out of the array

        
    
//partition like this
//[15] [7,9,2] [10]
//15*1 + 9*3 + 10*1 = 15 + 27 + 10 = 52
