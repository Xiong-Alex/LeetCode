class Solution {
    public int largestRectangleArea(int[] heights) {

        // Tracks the maximum rectangle area found
        int maxArea = 0;

        // Stack holds bars that can still extend to the right
        // Each item = {height, leftmostIndexItCanReach}
        Deque<int[]> stack = new ArrayDeque<>();

        for(int i = 0; i <= heights.length; i++) {

            // Use height 0 at the end so every bar gets processed
            int curHeight = (i == heights.length) ? 0 : heights[i];

            // Current bar starts at its own index
            int start = i;

            // If the current bar is shorter, taller bars are finished
            while(!stack.isEmpty() && stack.peek()[0] > curHeight) {

                int[] top = stack.pop();

                int h = top[0];
                int left = top[1];
                
                // This bar ends at index i - 1
                // Width = i - left
                maxArea = Math.max(maxArea, h * (i - left));

                // The shorter bar can stretch as far left as this one
                start = left;
            } 

            // Only add the bar if it doesn’t break the height order
            // (small → big from bottom to top)
            if (stack.isEmpty() || stack.peek()[0] < curHeight) {
                stack.push(new int[]{curHeight, start});
            }

        }

        return maxArea; 
    }
}

// Question
// Largest Rectancle possible given heights[]
// [i] represent height && index represents one width

// Brute force:  
    // calculate every possible solution | nested for loop

    // int maxArea = 0;
    // for(int i = 0; i < heights.length; i++) {
    //     int maxHeight = heights[i];
    //     for(int j = i; j < heights.length; j++) {
    //         maxHeight = Math.min(maxHeight, heights[j]);
    //         int width = j - i + 1;
    //         maxArea = Math.max(maxArea, maxHeight * width);
    //     }
    // }
    // return maxArea;

//////////////////////////////////////////////////////

// Optimal Solution:

// Still wrapping my brain around...



