package com.yifeng.BinaryTreeAndDivideConquer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


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
public class BinaryTreeLevelOrderTraversal {

	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
/**
 * 
 * @param root
 * @return
 * BFS宽度优先搜索的思路. 优先考虑使用queue;(一个queue最佳 )
 * 将每一层的节点先放入queue中，root最先放入queue（初始化时放入）
 * 利用for循环和queue.poll将每一层的节点取出，将值放入level中
 * 最后将level放入result中
 */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {//queue 非空时才能从里取值;
			ArrayList<Integer> level = new ArrayList<Integer>();
			//queue中size是动态变化的，必须先取出来在用于循环;
			int size = queue.size();
			for (int i = 0; i < size; i++) {//同一层的所有element都要先从queue取出再加入一个level中，再将其子节点加入到queue中
				TreeNode head = queue.poll();
				level.add(head.val);

				if (head.left != null) {
					queue.offer(head.left);
				}
				if (head.right != null) {
					queue.offer(head.right);
				}
			}
			result.add(level);
		}
		return result;
	}
}
