package wordSearch2;

//LeetCode #208 (Implement Trie (Prefix Tree)).

//Implement a trie with insert, search, and startsWith methods.

public class ImplementTrie {

	private TrieNode root;

	public ImplementTrie() {
		this.root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode cur = root;
		for (char ch : word.toCharArray()) {
			if (cur.children[ch - 'a'] == null) {
				cur.children[ch - 'a'] = new TrieNode();
			}
			cur = cur.children[ch - 'a'];
		}
		cur.word = word;
	}
	
	public TrieNode getRoot() {
		return root;
	}
}
