class Solution {
    public int lengthOfLongestSubstring(String s) {

        //dvdf
        
        int left = 0;
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();

        // Iterate through String
        for(int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Shrink window till strings becomes valid
            while(charSet.contains(ch)) {
                charSet.remove(s.charAt(left));
                left++;
            }

            // Add char back in (s.charAt(right)) to track it again
            charSet.add(ch);
            maxLength = Math.max(maxLength, right - left + 1);
        }
  
        return maxLength;

    }
}


// Notes 

// Problem:
// - Find the length of the longest contiguous substring
// - The substring must contain NO repeating characters

// Key Clarification:
// - Characters may repeat in the string overall
// - They may NOT repeat within the chosen substring (window)

// Why this problem is tricky:
// - Simple cases like "zxyzxyz" -> 3 are misleading
// - Overlapping substrings matter
//   Example: "dvdf"
//     - "dv" is valid
//     - When the second 'd' appears, we should NOT restart
//     - Shifting the window gives "vdf" -> length 3

// Core Insight:
// - A duplicate does NOT mean reset
// - A duplicate means the current window is invalid
// - We must shrink the window from the LEFT until it becomes valid again

// Example:
// "mdvdfo"
// - "mdv" is valid
// - Next 'd' is a duplicate
// - The repeat is NOT at the start of the window
// - We must move left forward until the previous 'd' is removed
// - New valid window becomes "vdfo"


