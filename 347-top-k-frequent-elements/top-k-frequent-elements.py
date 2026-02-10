from collections import Counter

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        # return dict | {number: count}
        freq = Counter(nums)

        #create list / sort via appearance / set reverrse / slice for first k elements
        return sorted(freq, key=freq.get, reverse=True)[:k]

