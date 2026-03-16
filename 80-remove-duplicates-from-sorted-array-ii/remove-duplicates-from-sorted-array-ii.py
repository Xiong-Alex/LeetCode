from collections import defaultdict

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:

        # result = []
        seen = defaultdict(int)
        left = 0

        for i in range(len(nums)):

            num = nums[i]



            if num not in seen or seen[num] < 2:
                seen[num] += 1
                nums[left] = num
                left += 1


        return  left

        # for num in nums:

        #     if seen[num] < 2:
        #         seen[num] + 1
        #         result.append(num)

        # return  result

        
            

            
        