class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        map = {}

        for i, num in enumerate(nums):
            diff = target - num

            if diff in map:
                return [i, map[diff]]
            else:
                map[num] = i


# Enumerate() turns list into tuple (index, value)
# dictionary doesnt have contains, but it has 'in' 