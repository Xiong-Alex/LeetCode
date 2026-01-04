class Solution {
    public int search(int[] nums, int target) {

        // Tracking Pointers
        int left = 0;
        int right = nums.length - 1;

        // Loop until ==
        while(left <= right) {

            // Mid Point
            // left + (right - left) / 2 ----------- This prevents overflow at extremes vs (right + left) / 2
            int mid = left + (right - left) / 2;

            // if ==, we fouind our target
            if(nums[mid] == target) return mid;

            // Shift left pointer in
            if(target > nums[mid]) {
                left = mid + 1;

            // Shift right pointer in
            } else {
                right = mid - 1;
            }

        }
        
        // Default not found
        return - 1;
    }
}
