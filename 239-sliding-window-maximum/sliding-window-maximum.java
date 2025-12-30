class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] output = new int[nums.length - k + 1];
        int n = nums.length;

        // Store indices & values in decreasing order
        // nums[dq[0]] >= nums[dq[1]] >= ...
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int right = 0; right < n; right++) {
            int left = right - k + 1; // left bound of current window (once window is size k)

            if(!dq.isEmpty() && dq.peekFirst() < left) {
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[right]) {
                dq.removeLast();
            }

            dq.addLast(right);

            if (right >= k - 1) {
                output[left] = nums[dq.peekFirst()];
            }
        }

        return output;
    }
}

// Brute Force

// Notes:
// Loop through array & utilize window
// loop through window and check for max each time
// works but slow O(n^2)
// REAL PROBLEM | is how to modify window and not rebuild and Math.max each time

// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {

//         int[] output = new int[nums.length - k + 1];
//         // Loop Through Array
//         for(int i = 0; i < nums.length - k + 1; i++) {
//             int max = 0;
//             // Loop through window
//             for(int j = i; j < i + k; j++) {
//                 // int max outisde loop
//                 max = Math.max(max, nums[j]);
//             }
//             output[i] = max;
//         }
//         return output;
//     }
// }
