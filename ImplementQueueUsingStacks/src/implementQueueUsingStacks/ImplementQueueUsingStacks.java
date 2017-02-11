package implementQueueUsingStacks;

import java.util.LinkedList;

// LeetCode #232

// Implement Queue Using Stacks.

public class ImplementQueueUsingStacks {

	LinkedList<Integer> stack1;
	LinkedList<Integer> stack2;

	public ImplementQueueUsingStacks() {
		stack1 = new LinkedList<>();
		stack2 = new LinkedList<>();
	}

	public void push(int x) {
		stack1.offerLast(x);
	}

	public int pop() {
		int result = peek();
		stack2.pollLast();
		return result;
	}

	public int peek() {
		if (stack2.size() > 0) {
			return stack2.peekLast();
		} else {
			int size = stack1.size();
			for (int i = 0; i < size; i++) {
				stack2.offerLast(stack1.pollLast());
			}
			return stack2.peekLast();
		}
	}

	public boolean empty() {
		return stack1.size() + stack2.size() == 0;
	}
}
