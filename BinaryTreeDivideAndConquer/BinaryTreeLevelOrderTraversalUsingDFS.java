package com.yifeng.BinaryTreeAndDivideConquer;

import java.util.ArrayList;

/*
Given a binary tree, return the level order traversal of its nodes' values. 
(ie, from left to right, level by level).
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]

 */

public class BinaryTreeLevelOrderTraversalUsingDFS {

	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null) {
			return result;
		}
		int maxLevel = 0;
		while (true) {
			ArrayList<Integer> level = new ArrayList<Integer>();
			dfs(root, level, 0, maxLevel);
			if (level.size() == 0) {
				break;
			}

			maxLevel++;
			result.add(level);

		}
		return result;

	}

	private void dfs(TreeNode root, ArrayList<Integer> level, int currentLevel, int maxLevel) {

		if (root == null || currentLevel > maxLevel) {
			return;
		}

		if (currentLevel == maxLevel) {
			level.add(root.val);
			return;
		}

		dfs(root.left, level, currentLevel + 1, maxLevel);
		dfs(root.right, level, currentLevel + 1, maxLevel);
	}

}