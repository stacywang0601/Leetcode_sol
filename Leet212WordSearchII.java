package B08_13;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells
 * are those horizontally or vertically neighboring. The same letter cell may not be used more than
 * once in a word.
 * 
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 * 
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 */
import java.util.ArrayList;
import java.util.List;

public class Leet212WordSearchII {
	/**
	 * Trie tree(Storing word itself at leaf node) + DFS
	 * No need to use O(n^2) extra space visited[m][n]-->change board to "#"
	 * No need to use HashSet to de-duplicate--p.word = null, remove from tree
	 * if (p.word != null) { // found one
	 * res.add(p.word);
	 * p.word = null; // de-duplicate
	 * }
	 */
	private char[][]	board;

	public List<String> findWords(char[][] board, String[] words) {
		this.board = board;
		List<String> res = new ArrayList<>();
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(i, j, root, res);
			}
		}
		return res;
	}

	public void dfs(int i, int j, TrieNode p, List<String> res) {
		char c = board[i][j];
		if (c == '#' || p.next[c - 'a'] == null)
			return;
		p = p.next[c - 'a'];// 向下走
		if (p.word != null) {   // found one
			res.add(p.word);
			p.word = null;     // de-duplicate
		}
		board[i][j] = '#';  // visited may not be used more than once in a word
		if (i > 0)
			dfs(i - 1, j, p, res);
		if (j > 0)
			dfs(i, j - 1, p, res);
		if (i < board.length - 1)
			dfs(i + 1, j, p, res);
		if (j < board[0].length - 1)
			dfs(i, j + 1, p, res);
		board[i][j] = c;
	}

	public TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String w : words) {
			TrieNode p = root;
			for (char c : w.toCharArray()) {
				int i = c - 'a';
				if (p.next[i] == null)
					p.next[i] = new TrieNode();
				p = p.next[i];
			}
			p.word = w;
		}
		return root;
	}

	class TrieNode {
		TrieNode[]	next	= new TrieNode[26];
		String		word;
	}
}