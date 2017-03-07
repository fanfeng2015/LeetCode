package gasStation;

// LeetCode #134

// There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
// You begin the journey with an empty tank at one of the gas stations.
// Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

// The solution is guaranteed to be unique.

public class GasStation {

	// Fact 1: If a car can not reach station B from station A, then it can not
	// reach station B, from any station at [A, B).
	// Fact 2: If the total number of gas is greater than the total number of
	// cost, there must exist a solution.

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0, gasInTank = 0, sum = 0;
		for (int i = 0; i < gas.length; i++) {
			gasInTank += gas[i] - cost[i];
			if (gasInTank < 0) {
				start = i + 1;
				sum += gasInTank;
				gasInTank = 0;
			}
		}
		return sum + gasInTank >= 0 ? start : -1;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
