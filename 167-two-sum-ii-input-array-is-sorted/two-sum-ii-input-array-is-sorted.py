class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        
        #binary serach | left/right

        left = 0
        right = len(numbers) - 1

        while left < right:
            total = numbers[left] + numbers[right]

            if total == target:
                return [left + 1, right + 1] # 1 index based

            if total > target:
                right -= 1
            else:
                left += 1
