class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix; 
            prefix *= nums[i]; 
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;
    }
}  

// Notes

// sol 1
// brute force & loop through n times

// sol 2
// Init thoughts/solutions
// multiply all, divide by [i] (but check if 0 first, if 0 default 0)

// sol 3
// Two passes, calc product moving forward | backwards
// on the loop forward, only products previous of [i] will be calculated.
//  on the loop back, only products after [i] will be calculated
// thus do both sides and we get products of array except self.