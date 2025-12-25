class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        int[] count = new int[26];

        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int c : count) {
            if(c != 0) return false;
        }

        return true;
    }
}

// Notes
// Identify Problem | What is anagram?
// Anagram = any word that can be rearranged to make another word, not just reverse.

// Solution
// Utilize an arr[26] to track letters and their freqency;

// As we loop string everytime we see a letter we increment their freq
// Concurrently we do the same for the second string but we dec
// if true anagram, all values should negate out and be 0;

// thus utilize a foreach and check at the end