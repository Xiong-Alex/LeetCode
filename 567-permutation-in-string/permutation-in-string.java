class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // Edge case, s2 cant be smaller than s1
        if(s1.length() > s2.length()) return false;

        int windowSize = s1.length();

        // Track window char freq
        int[] freq = new int[26];

        //Add And Check everything initially w/first window
        // add s1 into freq
        for (int i = 0; i < windowSize; i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        // subtract first window of s2 
        for (int j = 0; j < windowSize; j++) {
            freq[s2.charAt(j) - 'a']--;
        }

        // Utilize helper function to check if allZero
        // [i] should negate to all 0 if contains | s1 does +1, whereas s2 does -1
        if (allZero(freq)) return true;

         // slide and repeat for rest of s2
        for (int left = 0; left + windowSize < s2.length(); left++) {
            int outIdx = s2.charAt(left) - 'a';
            int inIdx = s2.charAt(left + windowSize) - 'a';

            freq[outIdx]++; // out leaves window
            freq[inIdx]--;  // in enters window

            if (allZero(freq)) return true;
        }

        // Default false
        return false;

    }

    
    private boolean allZero(int[] freq) {
        for (int f : freq) {
            if (f != 0) return false;
        }
        return true;
    }

}

// Notes

// Soltuion (optimalish) / 

// KEY IDEA:
// freq[c] = (# of char c needed from s1) - (# of char c in current window of s2)

// Meaning of freq values:
// - freq[c] > 0  → window is MISSING this many of char c
// - freq[c] == 0 → window has EXACTLY the right count of char c
// - freq[c] < 0  → window has EXTRA char c (or char not needed at all)

// Slide through s2 while checking for s1 via freq[]
// if all 0's, return true / default false

////////////////////////////

// Initial Thoughts,
// sliding window, but window is fixed to s1.length

// question is how to check as we slide,
// initial solution would be to dyamically convert our window into a hashmap or [26] (thought set originally, but that doesnt track freq)
// and check if each char is s1 is in it and decrement as we go.

///////////////////////////

// Original bruteforce solution

// class Solution {
//     public boolean checkInclusion(String s1, String s2) {

//         // Edge case, s2 cant be smaller than s1
//         if(s1.length() > s2.length()) return false;

//         // Loop through S2
//         for(int left = 0; left + s1.length() < s2.length(); left++) {

//             // Trach window char freq
//             int[] freq = new int[26];

//             // loop through s2 window & add char freq to []
//             for(int j = left; j < left + s1.length(); j++) {
//                 int idx = s2.charAt(j) - 'a';
//                 freq[idx]++;
//             }

//             // Check Window freq w/ s1 | [i]--  | this should make everything 0, if valid
//             for(int i = 0; i < s1.length(); i++) {

//                 int s1Idx = s1.charAt(i) - 'a';
//                 freq[s1Idx]--;
//             }

//             // Check if has permutation
//             boolean hasPermutation = true;
//             for(int f : freq) {
//                 if(f != 0) hasPermutation = false;
//             }

//             // If so return true
//             if(hasPermutation) {
//                 return true;
//             }

//         }

//         // Default false
//         return false;

//     }
// }