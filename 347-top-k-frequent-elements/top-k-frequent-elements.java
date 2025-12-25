class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // Record all nums and their freq
        Map<Integer, Integer> numFreq = new HashMap<>();
        for(int n : nums) {
            numFreq.put(n, numFreq.getOrDefault(n, 0) + 1);
        }

        // Bucket Sort
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int num : numFreq.keySet()) {
            //grab freq for that num
            int freq = numFreq.get(num);

            //if this freq doesnt exist create it
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            } 

            //add num to bucket..?
            buckets[freq].add(num);
        }

        // Grab our most frequent K elements and store in []
        int[] res = new int[k];
        int index = 0;

        // Start search from the back (largest/most freq)
        // breaks if f >= 0 (no need to check [0] because 0 means theres no freq) 
        // && 
        // index < k (found all k freq element alr)
        for (int f = buckets.length - 1; f >= 0 && index < k; f--) {

            //check if this freq contains number
            if (buckets[f] != null) {
                //if it does, iterate through that list
                for (int num : buckets[f]) {
                    //set res[i] = num && increase index for the next element
                    res[index++] = num;
                    //if index is the same, 
                    // break we dont need to check for anymore because we have our k most freq elements
                    if (index == k) break;
                }
            }
        }

        return res;

    }
}

// Notes

// brute force | HashMap <int, freq>, build freq map, iterate/compare everything everytime to find top k elements

// Optimal | build freq map, bucket sort, store/fetch top k elements
