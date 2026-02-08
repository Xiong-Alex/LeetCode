from collections import defaultdict

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        if len(s) != len(t):
            return False

        freq = [0] * 26

        for c in s:
            freq[ord(c) - ord('a')] += 1

        for c in t:
            freq[ord(c) - ord('a')] -= 1
            
        for char_freq in freq:
            if char_freq != 0:
                return False

        return True

    #Solution 2 use arrayFreq based
    # slightly faster than map

    #Utilze ord() to get unicode for letter

    # Solution 1 | dicts
        # anagram_dict = defaultdict(int)

        # #first loop | count char in first word
        # for c in s:
        #     anagram_dict[c] += 1
        
        # #second loop | count/subtract char from second word
        # for c in t:
        #     anagram_dict[c] -= 1

        # #char count should cancel out and == 0
        # #if not == 0, not anagram
        # for count in anagram_dict.values():
        #     if count != 0:
        #         return False

        # #default true
        # return True