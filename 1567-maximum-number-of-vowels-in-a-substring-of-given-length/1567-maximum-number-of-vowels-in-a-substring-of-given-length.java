class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int count = 0, maxCount = 0;

        for (int i = 0; i < n; i++) {
            // Add current character if it's a vowel
            if (isVowel(s.charAt(i))) {
                count++;
            }

            // Remove the leftmost character of the previous window
            if (i >= k && isVowel(s.charAt(i - k))) {
                count--;
            }

            // Track the maximum vowels seen so far
            maxCount = Math.max(maxCount, count);

            // If we already hit k vowels, we can't do better
            if (maxCount == k) {
                return k;
            }
        }

        return maxCount;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
