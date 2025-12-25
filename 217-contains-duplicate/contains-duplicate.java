import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        //HashSet stores only uniques
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // duplicate found
            }
            seen.add(num);
        }

        //default no duplicates
        return false; 
    }
}

//Explanation:
// A HashSet stores values only once
// so we loop through the array, if already contained in set we add to it and move on
// if our 'if' statement ever is true we've ran into a duplicate
// so we end early w/a true
// otherwise if will default to false for no dupes found