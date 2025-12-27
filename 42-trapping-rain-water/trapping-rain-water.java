class Solution {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int maxArea = 0;

        while(left < right) {


            // Check for Smaller Height Col
            if(height[left] < height[right]) {

                // check if new col is the same or larger / cant store water
                if(height[left] >= leftMax) {
                    leftMax = height[left];
                
                //This new col is smaller, thus it can store water
                } else {
                    maxArea += leftMax - height[left];
                }

                // increment left col over
                left++;

            // Right Col Height is smaller
            } else {

                // check if new col is the same or larger / cant store water
                if(height[right] >= rightMax) {
                    rightMax = height[right];

                //This new col is smaller, thus it can store water
                } else {
                    maxArea += rightMax - height[right];
                }
                right--;
            }

        }

        return maxArea;
        
    }
}

// Notes:
// Two Pointer Problem

// Solution)
// Key point: need to know the height of the smaller side Min(leftMax, rightMax)
//     That determines the height of whats in between, Until a bigger Col is hit.
//     Increment inwards on the smaller side because its capped off based on its height.
//     Compare the new left/right w/the previous leftMax/rightMax and calc for the area and add to maxArea

// Note: no need to calc min height Math.min(leftMax, rightMax)
//       if we're moving in from the left side, we know that the min height is left, and vise versa
