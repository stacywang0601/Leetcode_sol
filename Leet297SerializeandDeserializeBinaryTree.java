package B06_21;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so
 * that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how
 * your serialization/deserialization algorithm should work. You just need to ensure that a binary
 * tree can be serialized to a string and this string can be deserialized to the original tree
 * structure.
 * For example, you may serialize the following tree
 * 
 * 1
 * / \
 * 2 3
 * / \
 * 4 5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not
 * necessarily need to follow this format, so please be creative and come up with different
 * approaches yourself.
 * Note: Do not use class member/global/static variables to store states. Your serialize and
 * deserialize algorithms should be stateless.
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int	     val;
	TreeNode	left;
	TreeNode	right;

	TreeNode(int x) {
		val = x;
	}
}

public class Leet297SerializeandDeserializeBinaryTree {
	/**
	 * For serialize:
	 * Print the tree in pre-order traversal
	 * Use "#" to denote null node and split node with ","
	 * Use a StringBuilder for building the string on the fly.
	 * 
	 * For deserialize:
	 * Use a Queue to store the pre-order traversal
	 * since we have "#" as null node, we know
	 * exactly how to where to end building subtress.
	 */
	class Codec {
		public String serialize(TreeNode root) {
			return serial(new StringBuilder(), root).toString();
		}

		// Generate preorder string
		private StringBuilder serial(StringBuilder str, TreeNode root) {
			if (root == null)
				return str.append("#,");
			str.append(root.val).append(",");
			serial(str, root.left);
			serial(str, root.right);
			return str;
		}

		public TreeNode deserialize(String data) {
			return deserial(new LinkedList<String>(Arrays.asList(data.split(","))));
		}

		// Use queue to simplify position move
		private TreeNode deserial(Queue<String> q) {
			String val = q.poll();
			if ("#".equals(val))
				return null;
			TreeNode root = new TreeNode(Integer.valueOf(val));
			root.left = deserial(q);
			root.right = deserial(q);
			return root;
		}

	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

