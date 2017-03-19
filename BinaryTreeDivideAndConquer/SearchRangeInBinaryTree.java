package com.yifeng.BinaryTreeAndDivideConquer;
import java.util.*;

 // Definition of TreeNode:
  
 
public class SearchRangeInBinaryTree {
	private class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    private ArrayList<Integer> results;
    
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        results = new ArrayList<Integer>();
        helper(root,k1,k2);
        return results;
    }
    
    private void helper(TreeNode root,int k1,int k2){
        if(root == null){
            return;
        }
        if(root.val > k1){
            helper(root.left,k1,k2);
        }
        if(root.val >= k1 && root.val <= k2){//加入条件;
            results.add(root.val);
        }
        if(root.val < k2){
            helper(root.right,k1,k2);
        }
    }
}
