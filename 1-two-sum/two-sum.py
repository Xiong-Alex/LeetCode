class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        num_set = {}

        for index, num in enumerate(nums):
            diff = target - num

            if diff in num_set:
                #NeetCode requires it to be sorted
                #more eff w/an if else but, thisis fine
                return sorted([index, num_set[diff]])

            num_set[num] = index

        #default empty
        return []