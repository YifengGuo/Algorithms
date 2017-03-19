package com.yifeng.BinaryTreeAndDivideConquer;

import java.util.*;

//Example of iterate a tree:
//	  BSTIterator iterator = new BSTIterator(root);
//	  while (iterator.hasNext()) {
//	     TreeNode node = iterator.next();
//	    do something for node

/*
Design an iterator over a binary search tree with the following rules:

Elements are visited in ascending order (i.e. an in-order traversal)
next() and hasNext() queries run in O(1) time in average.
Example
For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]

   10
 /    \
1      11
 \       \
  6       12
*/
public class BSTIterator {
	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode curt;

	public BSTIterator(TreeNode root) {
		// 先找到第一个节点，并把路径入栈
		while(root != null){
            stack.push(root);
            root = root.left;
        }
	}

	public boolean hasNext() {
		// 栈为空时不再有下一个
		return !stack.isEmpty();
	}

	public TreeNode next() {
		// 栈顶是待返回元素
		curt = stack.pop();
		TreeNode next = curt;
		// 如果该元素有右节点，把它的右节点及右节点的所有左边节点都压入栈中
		if (curt.right != null) {
			curt = curt.right;
			while (curt != null) {
				stack.push(curt);
				curt = curt.left;
			}
		}
		return next;
	}
}
