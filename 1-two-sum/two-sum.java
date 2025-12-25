class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if(map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[0];
    }
}

// Notes:
// Two main approaches

// 1 ) Sort nums
// then use two pointers <left, right> and inc/dec till you get target

// 2 ) HashMap
// Iterate through arr, check map for diff (target - nums[i]), if diff doesnt exist add <nums[i], i> to map and continue
// This works because we can check the required difference value/index, and we only add the current value/index to the hashmap
// after we check, so we dont have to worry about duplicates.
