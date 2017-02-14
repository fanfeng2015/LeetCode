package implementStackUsingQueues;

import java.util.LinkedList;

// LeetCode #225

// Implement stack using queues.

public class ImplementStackUsingQueues {

	LinkedList<Integer> queue = new LinkedList<>();

	public ImplementStackUsingQueues() {
		queue = new LinkedList<>();
	}

	public void push(int x) {
		queue.offerLast(x);
		int size = queue.size() - 1;
		for (int i = 0; i < size; i++) {
			queue.offerLast(queue.pollFirst());
		}
	}

	public int pop() {
		return queue.pollFirst();
	}

	public int top() {
		return queue.peekFirst();
	}

	public boolean empty() {
		return queue.size() == 0;
	}

	// Time complexity is O(n) for push, and O(1) for pop and top.
	// There is a trade-off between push and pop.
	// Another implementation would rearrange elements only when pop or top is
	// called.
	// That way, push is O(1), and pop and top is O(n).

	public void push2(int x) {
		queue.offerLast(x);
	}

	public int pop2() {
		int size = queue.size() - 1;
		for (int i = 0; i < size; i++) {
			queue.offerLast(queue.pollFirst());
		}
		return queue.pollFirst();
	}

	public int top2() {
		int result = pop2();
		queue.offerLast(result);
		return result;
	}

	public boolean empty2() {
		return queue.size() == 0;
	}

}