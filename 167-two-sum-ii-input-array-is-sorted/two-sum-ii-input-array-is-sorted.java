class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            int leftVal = numbers[left];
            int rightVal = numbers[right];

            int total = leftVal + rightVal;

            if(total < target) {
                left++;
            } else if(total > target) {
                right--;
            } else {
                return new int[] { left + 1, right + 1 };
            }

        }

        return new int[0];
    }
}


// Notes

// Utilize 2 pointers
// Left & Right
// if total < target, inc left pointer. This will make the total bigger
// if total > target, dec right pointer. This will make total smaller

// This only works because its sorted*

// NeetCode wants element
// LeetCode wants index & is []1 based