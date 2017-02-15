package fizzBuzz;

import java.util.ArrayList;
import java.util.List;

// LeetCode #412

// Write a program that outputs the string representation of numbers from 1 to n.
// But for multiples of three it should output "Fizz" instead of the number and 
// for the multiples of five output “Buzz”. For numbers which are multiples of both
// three and five output “FizzBuzz”.

public class FizzBuzz {

	public List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				result.add("FizzBuzz");
			} else if (i % 5 == 0) {
				result.add("Buzz");
			} else if (i % 3 == 0) {
				result.add("Fizz");
			} else {
				result.add(Integer.toString(i));
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1), ignoring space needed for output.
}
