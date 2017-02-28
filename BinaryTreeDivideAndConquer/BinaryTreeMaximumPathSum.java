package com.yifeng.BinaryTreeAndDivideConquer;

/*
Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.
*/

//变化分析：
//1. root -> leaf; like maximum depth question;
//2. root -> any node may exist node with negative value. This path contains at least one node;
		//return Math.max(left,right) + root.val at least one node;
//3. any node -> any node may exist node with negative value.
		//return Math.max(0,Math.max(left,right) + root.val); may contains 0 node;
		 


/**
 * 
 * @author guoyifeng
 * 1.全部在左子树
 * 2.全部在右子树
 * 3.跨过根节点，从根开始拆成两部分，max（往左＋往右）两条路径,其中一条路径可以为0个节点;
 *   max(left.singlePath + root + right.singlePath);
 */
public class BinaryTreeMaximumPathSum {
	
	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
	/*
	 * 因为要考虑当前节点的单边最大值和总路径的最大值，所以两个返回值的情况下
	 * 需要引入一个ResultType类来维护这两个值;
	 */
	private class ResultType{
		int singlePath, maxPath;
		public ResultType(int singlePath,int maxPath){
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		} 
	}
	
	public ResultType helper(TreeNode root){
		if(root == null){
			return new ResultType(0, Integer.MIN_VALUE);//退出时，极端情况下最大值设置为最小的一个值;
		}
		
		//divide
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		
		//每次递归返回的根节点的val就是每次增加的值;
		//当前根节点没有子节点则退出递归,返回相对于其父节点的左右子节点中的较大值;
		int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;//need to compare with 0 because can contain 0 node from left or right subtree;
		singlePath = Math.max(0, singlePath);//because node may contain negative value.
		
		int maxPath = Math.max(left.maxPath,right.maxPath);//全在左边或者全在右边；  
		maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);//update 跨过根节点的情况;
		
		//update value in ResultType;
		return new ResultType(singlePath, maxPath);
	}
	
	public int maxPath(TreeNode root){
		ResultType result = helper(root);
		return result.maxPath; 
	}
	
	
}
