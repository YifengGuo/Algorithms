package com.yifeng.BinaryTreeAndDivideConquer;
/*
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 *遍历法:将结果集作为参数在traverse中调用，递归地进行前序遍历;
 */
import java.util.ArrayList;

public class BinaryTreePreorderTreversal {
	
	
	/**
	 * 
	 * @param root
	 * @return result
	 * 遍历法前序遍历二叉树;
	 */
	/*
	public ArrayList<Integer> preorderTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		traverse(root, result);
		return result;
	}
	
	public void traverse(TreeNode root, ArrayList<Integer> result){
		if(root == null){
			return;
		}
		
		result.add(root.val);
		traverse(root.left, result);
		traverse(root.right,result);
	}
	*/
	/**
	 * 
	 * @param root
	 * @return result
	 * divide conquer法前序遍历二叉树;
	 * 因为是用数组，所以时间复杂度为O(n^2)；
	 */
	/*
	public ArrayList<Integer> preorderTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if(root == null){
			return result;
		}
		
		//divide
		ArrayList<Integer> left = preorderTraversal(root.left);
		ArrayList<Integer> right = preorderTraversal(root.right);
		
		//conquer
		result.add(root.val);
		result.addAll(left);//addAll used in add collections;
		result.addAll(right);
		return result;

	}
	*/
	
	
	
}
