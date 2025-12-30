class Solution {
    public int lengthOfLastWord(String s) {

        // start from the back
        int i = s.length() - 1;
        int length = 0;

        // skip all empty ' '
        while(i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // count all valid char until ' '
        while(i >= 0 && s.charAt(i) != ' ') {
            i--;
            length++;
        }

        return length;
    }
}

// or just bamm, but slower

// String[] words = s.split("\\s");
// return words[words.length - 1].length();