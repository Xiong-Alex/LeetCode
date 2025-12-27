class Solution {
    public int characterReplacement(String s, int k) {
        
        int maxCount = 0;
        int maxFreq = 0;
        int left = 0;

        int[] charFreq = new int [26];

        // loop through string
        for(int right = 0; right < s.length(); right++) {

            // Grab current ind and add to charFreq
            int idx = s.charAt(right) - 'A';
            freq[idx]++;

            // Update maxFreq w/new char
            maxFreq = Math.max(maxFreq, freq[idx]);

            // replacements needed = windowSize - maxFreq
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;

    }
}






// Return to later, still hurts my brain

// Initial Solution
//_______________________________________________

// int maxCount = 0;
// int left = 0;

// int[] charFreq = new int [26];

// // loop through string
// for(int right = 0; right < s.length(); right++) {

//     char ch = s.charAt(right);
//     int chIndex = ch - 'A';

//     charFreq[chIndex]++;

//     // Determine most common Char and its FREQ

//     int mostCommonChar = 0;
//     int mostCommonCharFreq = 0;

//     for(int i = 0; i < charFreq.length; i++) {

        
//         if(charFreq[i] >= mostCommonCharFreq) {
//             mostCommonChar = i;
//             mostCommonCharFreq = charFreq[i];
//         }
    
//     }

//     // we know the most frequent char and its count
//     int limit = (right - left + 1) - mostCommonCharFreq;

//     // Below limit, scan forward.
//     if(limit <= k) {
//         maxCount = Math.max(maxCount, right - left + 1);
//     // Reached limit, move forward
//     } else {
//         charFreq[left]--;
//         left++;
//     }

// }

// return maxCount;
