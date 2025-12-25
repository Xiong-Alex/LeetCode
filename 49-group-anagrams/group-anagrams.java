class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //Store Anagram Key & List of anagram words
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {

            // Count Char Freq
            int[] count = new int[26];

            for(int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }

            // Create key based off count[] char freq.
            StringBuilder key = new StringBuilder();
            for(int c : count) {
                key.append('#').append(c);
            }

            // If this key/anagram doesnt exist yet, create it
            map.putIfAbsent(key.toString(), new ArrayList<>());
            // add String to existing Anagram List
            map.get(key.toString()).add(s);
        }

        // return converted Map as ArrayList
        return new ArrayList<>(map.values());
    }
}

// Notes

// Problem
// we now have a list of anagrams that we need to sort & return

// Solution 1 (Brute Force)
// sort each string, compare, and group/add to arrayList

// Solution 2 (Optimal)
// utilize hashamp and anagram key. check key for each String if same add to Arr List

// This is just like a normal anagram solution, 
// except we convert the count[] into a string in order to use as a key
// Utilize Delmiter when converting [] into key to ensure correct frequency of each char

// From there we check if our set has our key, 
// if it doesnt, a new entry <Key, new ArrayList<>>
// then add our current String to our entry String<> based on the key.

