package com.yifeng.BinaryTreeAndDivideConquer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.yifeng.BinaryTreeAndDivideConquer.BinaryTreeLevelOrderTraversal.TreeNode;

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

	}

}