class Solution {
    public int firstUniqChar(String s) {
        // first non-repeating character


        int[] freq= new int[26];
         //count frequency
          for(char c:s.toCharArray()){
            freq[c-'a']++;
          }
          //finding first unique char
           for(int i=0; i<s.length() ;i++){
             if(freq[s.charAt(i)- 'a'] ==1){
                 return i;
             }
           }
            return -1;
        
    }
}