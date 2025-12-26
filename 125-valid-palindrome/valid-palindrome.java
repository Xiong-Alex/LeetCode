class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while(left < right) {

            // skip non char/digits on left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // skip non char/digits on right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Check if left char == right char
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }

            // inc & dec pointers
            left++;
            right--;
        }

        return true;
    }
}

// Notes

// sol 1) Brute Force
// reverse String, check if string1.equals(string2)
// though this doesnt apply w/non-alphanumeric and case insensitive


// sol 2) Optimal
// two pointers, left / right check if they're equal
// skip non-alphanumeric
