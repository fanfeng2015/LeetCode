package accountsMerge;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// LeetCode #721 (Accounts Merge).

public class AccountsMerge {

	// [ John: [a, b, f], [John: c], [John: a, d], [Mary: e] ]
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, String> owners = new HashMap<>(); // { email: name }
		// { a: [a, b, f, d], b: [a], f: [a], c: [c], d: [a], e: [e] }
		Map<String, HashSet<String>> graph = new HashMap<>();
		// build owners and graph
		for (List<String> list : accounts) {
			for (int i = 1; i < list.size(); i++) {
				owners.put(list.get(i), list.get(0));
				if (!graph.containsKey(list.get(i))) {
					graph.put(list.get(i), new HashSet<String>());
				}
				graph.get(list.get(1)).add(list.get(i));
				graph.get(list.get(i)).add(list.get(1));
			}
		}
		// find connected components
		List<List<String>> result = new ArrayList<List<String>>();
		Set<String> visited = new HashSet<>();
		LinkedList<String> queue = new LinkedList<>();
		for (String email : graph.keySet()) {
			if (visited.add(email)) { // a new group
				queue.offerFirst(email);
				List<String> group = new LinkedList<String>(); // O(1) time for add(..., ...)
				while (!queue.isEmpty()) {
					String cur = queue.pollLast();
					group.add(cur);
					for (String neighbor : graph.get(cur)) {
						if (visited.add(neighbor)) {
							queue.offerFirst(neighbor);
						}
					}
				}
				Collections.sort(group);
				group.add(0, owners.get(email));
				result.add(group);
			}
		}
		return result;
	}

	// Time complexity is O(n*log(n)), because of sorting.
	// Space complexity is O(n).
}
