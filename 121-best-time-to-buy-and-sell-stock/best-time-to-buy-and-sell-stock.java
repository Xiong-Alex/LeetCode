class Solution {
    public int maxProfit(int[] prices) {
        
        // Edge Case, need 2 full days to buy and sell
        if(prices.length < 2) return 0;

        int maxProfit = 0;

        int left = 0;
        int right = 1;

        // Loop through w/Right Pointer
        while(right < prices.length) {

            // If left (our buy in) is ever more expensive than our sell out
            // set our buy in to right (cheaper buy in) & increment right to next day
            if(prices[left] > prices[right]  ) {

                // Note) we only ever want to update our left (buy in) if its cheaper than our right (sell out)
                left = right;
                right++;

                continue;
            }

            // At this point, our left (buy in) is cheaper than right (sell out)
            // Utilize Math.max to determine if this is optimal/max profit
            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);

            //Scan next day
            right++;
        }


        return maxProfit;

    }
}

    // Notes

    // I struggled really hard on this one ;-;
    // I flashed through 42. Trapping rain water | Hard | and then I get humbled by an easy T-T

    // Optiomal Solution) Key Points:
    // Sliding window / two-pointer approach
    // <left> tracks the lowest buy price seen so far
    // <right> scans forward and represents the current sell day
    // We only update <left> when we find a cheaper buy price
    // On each valid sell day, we update maxProfit using Math.max
    // This preserves the best profit even if a later lower price appears
    // Example: [2, 9, 1, 6]
    //   - Sell at 9 with buy at 2 → profit = 7
    //   - Later buy at 1 and sell at 6 → profit = 5
    //   - maxProfit remains 7

    // Initial / Brute Force Solution

        // if(prices.length < 1) return 0;
        // int maxProfit = 0;

        // for(int left = 0; left < prices.length - 1; left++) {

        //     int right = left + 1;

        //     if(prices[left] > prices[right]) continue;

        //     while(right < prices.length) {

        //         maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
        //         right++;
        //     }


        // }

        // return maxProfit;