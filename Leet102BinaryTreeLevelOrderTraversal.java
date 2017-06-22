package B04_25;

/**
 * 102. Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 3
 * / \
 * 9 20
 * / \
 * 15 7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int      val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
            val = x;
      }
}

public class Leet102BinaryTreeLevelOrderTraversal {
      /** Method1-- bfs */
      public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                  return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                  int levelNum = queue.size();
                  List<Integer> sublist = new ArrayList<>();
                  for (int i = 0; i < levelNum; i++) {
                        TreeNode node = queue.poll();
                        sublist.add(node.val);
                        if (node.left != null) {
                              queue.offer(node.left);
                        }
                        if (node.right != null) {
                              queue.offer(node.right);
                        }
                  }
                  res.add(sublist);
            }
            return res;
      }

      /** Method2--DFS */
      public List<List<Integer>> levelOrder2(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(root, res, 0);
            return res;
      }

      public void dfs(TreeNode node, List<List<Integer>> res, int level) {
            if (node == null) {
                  return;
            }
            if (res.size() < level + 1) {
                  res.add(new ArrayList<Integer>());
            }
            res.get(level).add(node.val);
            dfs(node.left, res, level + 1);
            dfs(node.right, res, level + 1);
      }
}