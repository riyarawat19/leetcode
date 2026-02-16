class Solution {
    public String reversePrefix(String word, char ch) {
        
        int index= word.indexOf(ch);
        //if char not found
        if(index==-1){
             return word;
        }
        String prefix= word.substring(0,index+1);
        String remaining= word.substring(index+1);

         String reversePrefix= new StringBuilder(prefix).reverse().toString();

         return reversePrefix + remaining;



    }
}