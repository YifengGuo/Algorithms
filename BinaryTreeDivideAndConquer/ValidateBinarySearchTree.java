package com.yifeng.BinaryTreeAndDivideConquer;
/*
Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST
*/
public class ValidateBinarySearchTree {

	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
	/*
	 * 根据bst的定义，判断是否是bst需要用到三个值，子树是否bst，最大值，最小值
	 */
	private class ResultType {
		boolean isBst;
		int maxValue, minValue;

		public ResultType(boolean isBst, int maxValue, int minValue) {
			this.isBst = isBst;
			this.maxValue = maxValue;
			this.minValue = minValue;
		}
	}

	public ResultType validateHelper(TreeNode root) {
		if (root == null) {
			return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);//产生非法值跳出递归时应给一个绝对安全的值用于下一段递归的正常比较；max就用Integer.MIN_VALUE,min Integer.MAX_VALUE
		}
		//divide 分别递归左子树和右子树;
		ResultType left = validateHelper(root.left);
		ResultType right = validateHelper(root.right);

		if (!left.isBst || !right.isBst) {
			return new ResultType(false, 0, 0);
		}
		//左右子树非空情况，如果值不对，也不是bst;
		if (root.left != null && left.maxValue >= root.val || root.right != null && right.minValue <= root.val) {
			return new ResultType(false, 0, 0);
		}
		//存在左子树或右子树为空的情况，所以在此情况下root可能为maxValue也可能为minValue，所以需要比较一下;   
		return new ResultType(true, 
							  Math.max(root.val, right.maxValue), 
					          Math.min(root.val, left.minValue));
	}

	public boolean isValidBST(TreeNode root) {
		ResultType result = validateHelper(root);
		return result.isBst;
	}
}
