class Solution {
    public int lengthOfLastWord(String s) {
        String str=s.trim();    //It removes all leading and trailing whitespace from the string s and stores the result in a new string variable str
        int count=0;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)!=' ')
            {
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}