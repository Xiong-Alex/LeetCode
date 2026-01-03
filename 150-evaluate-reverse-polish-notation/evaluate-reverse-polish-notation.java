class Solution {
    public int evalRPN(String[] tokens) {

        // Stack but better
        Deque<Integer> stack = new ArrayDeque<>();

        for (String t : tokens) {
            switch (t) {
                case "+" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                }
                case "-" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                }
                case "/" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                }
                default -> stack.push(Integer.parseInt(t));
            }
        }

        return stack.pop();
    }
}

// Notes: 

// Utilize Stack - 

// if operand, pop() pop() and perform calc then push back to stack
// default stack.push()

// Must Utilize stack over just string due multiple encapsulation within operation
// example (((1 + 2) * 3) - 4 * (4-2))
// if we just do left, right, operand. and iterate down it creates issues when you hit another ()

// stack ensures sub expressions are completed before being used
// Stack provdes the most recent values needed

