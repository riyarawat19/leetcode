// class Solution {
//     public int countSubstrings(String s) {
//         int n=s.length();
        
//          boolean[][]dp= new boolean[n][n];

          
//            int count=0;

//          for(int len=1;len<=n;len++){
//             for(int i=0; i+len-1<n ;i++){
//                  int j= i+len-1;

//                   if(s.charAt(i)==s.charAt(j)){
//                      if(len<=2){         // 2 ab already rejected
//                          dp[i][j]= true;
//                      }

//                      else{
//                          dp[i][j]= dp[i+1][j-1];// in length more than 3  i and j pointer shrink j
//                      }
//                   }
//                    if(dp[i][j]) count++;
//             }
//          }
//           return count;
//     }
// }
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }
}
