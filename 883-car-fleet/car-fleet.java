class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        // Edge case
        if(position.length < 2) return position.length;

        // Default 1 fleet | Minimum of 1 fleet must exist
        int fleetCount = 1;
        Deque<Double> stack = new ArrayDeque<>();

        // Create and format idx[]
        Integer[] idx = new Integer[position.length];
        for(int i = 0; i < position.length; i++) idx[i] = i;

        // Sort idx[] elements based on position
        Arrays.sort(idx, (a,b) -> Integer.compare(position[a], position[b]));


        for(int i = 0; i < position.length; i++) {
            
            // sorted pos index
            int carPos = idx[i];

            // Time the correct Car will arrive at its Destination
            stack.push((double) (target - position[carPos]) / speed[carPos]);
        }

        // cars behind need to reach destination at same time or sooner
        double leadingTime = stack.pop();

        while(!stack.isEmpty()) {

            // if car behind is fast enough to catch up
            // it adds to fleet, pop it & check next. 
            // Key note | leadingTime doesnt change because, original leading car is fastest possibble time due to its constraint as leader
            while(!stack.isEmpty() && leadingTime >= stack.peek()) {
                stack.pop();
            }

            // Current Car is too slow to catch up, causing new fleet behind
            // New fleet & newLeading Time
            if(!stack.isEmpty()) {
                fleetCount++;
                leadingTime = stack.pop();
            }
        }

        return fleetCount;
    }
}


// n = total cars in same direction on hwy

// position = car' location mile wise
// speed = car's speed

// target = distance destination is in miles

// car can not pass car ahead of it.
// it can only catch up & match speed (this only happens if car behind has faster speed & can make up time/distance)

// fleet = isNotEmpty set of cars w/same pos && speed (1 or more car == fleet)

// if car catches up to car fleet, the moment it reaches destination, it is considered to be added

// return number of car fleets that will arrive at destination.

///////////////////////////////////////////////////

// OPTIMAL SOLUTION

// Create int[] idx and populate with 0... arr.length
// sort idx[] based off pos[a], pos[b]

// this gives us the correct order for our cars.

// Then iterate through cars in the correct order based on pos (utilize idx[])
// determine speed and push into STACK

// leadingTime = time that the leadingCar in front will get to the destination.
// Their leadingTime determines how fast the fleet will travel.
// POP all instances that are faster or equal to leading time | They're in the current fleet.

// While popping, if carTime is slower than leadingTime,
// they cant catch up, and creates a new fleet && will have its own leadingTime.

// also verify if stack.isEmpty() throughout.


/////////////////////////////////

// TLDR:
// sort cars based on POS
// Calculate Time to Target
// Add car's Time to Stack

// Car In front (top of stack) leads fleet & dictates Pace.
// stack.pop() to remove all other cars in this fleet. // all cars faster or equal to leading pace

// Car that is too slow, cant catch up (longer time than leading Car)
// creates new fleet w/a differnt & slower pace.

// rinse and repeat for rest of cars