class Solution {
    public String minWindow(String s, String t) {

        // Edge case
        if (t.length() == 0 || s.length() < t.length()) return "";

        // freq = required counts from t
        int[] freq = new int[52];
        // windowFreq = counts in current window s[left..right]
        int[] windowFreq = new int[52];

        int left = 0;
        int minLeft = 0;
        int minLength = Integer.MAX_VALUE;

        // Build freq (need)
        for (int i = 0; i < t.length(); i++) {
            int idx = charToInt(t.charAt(i));
            freq[idx]++;
        }

        // Expand window with right pointer
        for (int right = 0; right < s.length(); right++) {
            int inIdx = charToInt(s.charAt(right));
            windowFreq[inIdx]++; // TRACK EVERYTHING (no if-check)

            // If valid, shrink as much as possible while staying valid
            while (isWindowValid(freq, windowFreq)) {

                int windowLength = right - left + 1;
                if (windowLength < minLength) {
                    minLength = windowLength;
                    minLeft = left;
                }

                // shrink: remove left char from window
                int outIdx = charToInt(s.charAt(left));
                windowFreq[outIdx]--;
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) return "";
        return s.substring(minLeft, minLeft + minLength);
    }

    // a-z => 0-25, A-Z => 26-51
    public int charToInt(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else {
            return 26 + (c - 'A');
        }
    }

    // Window is valid if for every required char: windowFreq >= freq
    // chars not in t have freq[i] == 0, so they are automatically ignored
    public boolean isWindowValid(int[] freq, int[] windowFreq) {
        for (int i = 0; i < 52; i++) {
            if (windowFreq[i] < freq[i]) return false;
        }
        return true;
    }
}



// Initial thought
// Sliding Window (as said in problem name)
// Window start length = t.length | but it can grow | chcek for requied char

// Track left char in sequence / Once it repeats, we shrink (shift left up until we hit a prev eligble char in sequence)



// t = xyyz
// s = xyyyyz

// if  xyyyyzx

// we hit a second x so then our left pointer shifts up
//      yyyyzx

// we also check required charFreq.
// so we dont only check if char != required Char
// we check when char == char, if char Freq > required

// we hit all char & charFreq
// the issue occurs when our window grows large enough and have more duplicates of a required char
