package com.yifeng.BinaryTreeAndDivideConquer;

/*
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a
binary tree in which the depth 
of the two subtrees of every node never differ by more than 1.
*/
public class BalancedBinaryTree {

	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	public boolean isBalanced(TreeNode root) {
		//不为－1时说明平衡，而为－1则可能左子树为－1或右子树为－1或左右子树高度差>1;
		return maxDepth(root) != -1;
	}

	private int maxDepth(TreeNode root) {
		if (null == root) {
			return 0;
		}
		
		//divide
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		
		// determine if one root's subtrees are balanced or not.
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}

}
