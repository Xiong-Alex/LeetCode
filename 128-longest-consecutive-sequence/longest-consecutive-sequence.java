class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        // add all nums to set
        for (int num : nums) {
            set.add(num);
        }

        // track longest 
        int longest = 0;

        // iterate through set
        for (int num : set) {

            // check for start of sequence
            if(!set.contains(num - 1)) {

                int current = num;
                int streak = 1;

                // count upward
                while(set.contains(current + 1)) {
                    current++;
                    streak++;
                }

                // update longest max()
                longest = Math.max(longest, streak);

            }
        }

        return longest;
    }
}

// Notes
// Solution 1) 
// brute force | looping through each individaully and dong + 1

// Solution 2)
// Utilize Set, add all to a set
// Loop through nums[i] and check if set contains nums[i] + 1
// This way we can check if next exists w/out having to manaully loop through array

// key details, check for (num -1) first to determine start point
// utilize while() to loop and check for (num + 1) & inc values
// after, update longest var via max()

// I like this problem, cool way to utilize set