from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        anagram_keys = defaultdict(list)

        for word in strs:

            #destructure/breakdown word & rearange to create key
            key = ''.join(sorted(word))

            #append to corresponding key
            #default dict bypasses logic for checking if key alr exists
            anagram_keys[key].append(word)

        
        return list(anagram_keys.values())





        

# class Solution:
#     def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

#         anagram_keys = {}

#         for word in strs:

#             #destructure/breakdown word & rearange to create key
#             key = ''.join(sorted(word))

#             if key not in anagram_keys:
#                 anagram_keys[key] = []

#             anagram_keys[key].append(word)

        
#         return list(anagram_keys.values())

        