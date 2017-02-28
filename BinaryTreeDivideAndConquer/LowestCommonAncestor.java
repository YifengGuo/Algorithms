package com.yifeng.BinaryTreeAndDivideConquer;

public class LowestCommonAncestor {
	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null) {
			return null;
		}
		//递归退出条件:发现目标节点并且此时目标节点为某次递归的root参数;
		//Root在就是所要找的两个节点之一，则直接返回Root，表明在当前链路中找到至少一个节点;
		if (root == A || root == B) {
			return root;
		}
		//调用递归,查看左子树的所有节点中是否存在目标节点；
		TreeNode left = lowestCommonAncestor(root.left, A, B);
		//调用递归,查看右子树的所有节点中是否存在目标节点；
		TreeNode right = lowestCommonAncestor(root.right, A, B);
		
		//说明目标节点一个在左子树中，一个在右子树中，LCA只能是根节点root；
		if (left != null && right != null) {
			return root;
		}
		//目标节点都在左子树中
		if (left != null) {
			return left;
		}
		//都在右子树中;
		if (right != null) {
			return right;
		}
		//没有找到目标;
		return null;
	}
}
