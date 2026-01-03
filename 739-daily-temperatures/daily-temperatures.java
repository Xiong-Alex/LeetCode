class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Loop through each day
        for(int day = 0; day < temperatures.length; day++) {

            // grab dailyTemp
            int dailyTemp = temperatures[day];

            // if stack empty or colder than previous day, add to stack
            if(stack.isEmpty() || temperatures[stack.peek()] >= dailyTemp) {
                stack.push(day);

            } else {

                // stack exists, and its a warmer day. Process previous days
                while(!stack.isEmpty() && dailyTemp > temperatures[stack.peek()]) {

                    // Grab previous Day
                    int prevDay = stack.pop();

                    // Calculate days since
                    result[prevDay] = day - prevDay;
                }

                // Add current day to stack
                stack.push(day);
            }

            // This works because we calc everything we can as we go, so we dont have to worry about a backlog or prev day w/lower temps
            // && only days that are higher remain to be calc in future.

        }

        return result;

    }
}

// Notes

// Variables
// Temperatures[i] = daily temp

// What it wants
// return resut[]
// result[i] represents days until higher temp

// Example
// Input: temperatures = [30,38,30,36,35,40,28]
// Output: results =     [ 1, 4, 1, 2, 1, 0, 0]

//////////////////////////////////////////////////

// Solution 1
// Count days until higher temp
// BRUTE FORCE would be to loop through each element && utilze nested to loop and count until higher temp

// Solution 2
// OPTIMAL SOLUTION
// Utilize stack to store day via index. (index allows us to still check temp temperature[temp] && determine what day it is)

// Storing index lets us:
// - compare temperatures via temperatures[index]
// - compute day difference (currentDay - prevDay)

// While the stack is not empty AND today’s temperature is higher than the temperature at the index on top of the stack:
//      Pop prevDay from stack
//      Set result[prevDay] = currentDay - prevDay
// Push currentDay onto the stack

// Key Insight
// The stack always contains index of days whose next warmer day has not been found yet, in decreasing temperature order.
// Any remaining index in stack has no warmer days && defaults to 0 (done automatically when creating [])
