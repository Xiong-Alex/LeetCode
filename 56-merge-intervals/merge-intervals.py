class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        
        result = []
        sortedIntervals = sorted(intervals, key=lambda x: (x[0], x[1]))

        for interval in sortedIntervals:
            left, right = interval

            if not result:
                result.append([left, right])
                continue

            prevLeft, prevRight = result[-1]

            if left <= prevRight:
                result[-1][1] = max(prevRight, right)
            else:
                result.append([left, right])

        return result