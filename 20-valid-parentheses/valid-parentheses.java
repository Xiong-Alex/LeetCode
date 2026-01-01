class Solution {
    public boolean isValid(String s) {

        // Dq is more efficient than normal stack & has same func
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) return false;

            char top = stack.pop();

            if (
                (c == ')' && top != '(') ||
                (c == ']' && top != '[') ||
                (c == '}' && top != '{')
            ) return false;

        }


        return stack.isEmpty();
        
    }
}

// NOTES

// Utilize Stack or ArrayDeque (stack but better)
// Push opening char, & when closing char we pop & validate if true/match

// we can not just utilize 2 pointers and check both ends
// because "[()([])]"
// That would break it
// its valid as along as it properly closes