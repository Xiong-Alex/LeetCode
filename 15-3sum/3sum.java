class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        // Sort asc
        Arrays.sort(nums);
        
        for(int left = 0; left < nums.length - 2; left++) {

            // skip repeat num
            if(left > 0 && nums[left] == nums[left-1]) continue;

            int mid = left + 1;
            int right = nums.length - 1;

            while(mid < right) {

                int total = nums[left] + nums[mid] + nums[right];

                if(total > 0) {
                    right--;
                } else if (total < 0) {
                    mid++;
                } else {
                    res.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    mid++;
                    right--;

                    // skip duplicates for mid/right
                    while (mid < right && nums[mid] == nums[mid - 1]) mid++;
                    while (mid < right && nums[right] == nums[right + 1]) right--;
                }
            }



        }

        return res;
    }
}

// Notes: 
// Sort the array asc, and loop through them, and inside use a 2 pointer to check for everything in between
// additional check on duplicate, check left first, if dupe continue

// This qustion combines the 2sum series questions
