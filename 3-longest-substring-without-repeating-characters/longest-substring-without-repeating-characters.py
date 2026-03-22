class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxLength = 0
        charSet = set()

        l = 0


        if len(s) <= 1:
            return len(s)

        for i in range(len(s)):
            
            c = s[i]

            while c in charSet and l <= i:
                charSet.remove(s[l])
                l += 1

            charSet.add(c)
            maxLength = max(maxLength, len(charSet))

        return maxLength


        
        # for c in s:
            
        #     while c in charSet:
        #         charSet.remove(c)
        #         #issue is eveyrthing before is still kept not valid
        #         #is set right? 
        #         #if we hit dupe, we need to get rid/clear until just d....

        #     charSet.add(c)
        #     maxLength = max(maxLength, len(charSet))

        # return maxLength
            


