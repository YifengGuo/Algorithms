package com.yifeng.BinaryTreeAndDivideConquer;
import java.util.*;

public class BinaryTreeInorderTraversal {
	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: Inorder in ArrayList which contains node values.
	 */
	
	
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		ArrayList<Integer> results = new ArrayList<>();
		TreeNode curt = root;
		while(curt != null || !stack.isEmpty()){//whenever the stack is not empty;
			while(curt != null){//whenever a root exists, first push itself and all the nodes on the left into the stack;
				stack.push(curt);
				curt = curt.left;
			}
			curt = stack.peek();//assign the curt as the top element of the stack without popping it;
			stack.pop();
			results.add(curt.val);
			curt = curt.right;//if curt.right == null, the inner loop will not operate,then check stack is empty or not in outer loop;
		}
		return results;
	}
}

/* 分治法:

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
		
		if(root == null){
			return result;
		}
		
		//divide
		ArrayList<Integer> left = inorderTraversal(root.left);
		ArrayList<Integer> right = inorderTraversal(root.right);
		
		//conquer
		
		result.addAll(left);//addAll used in add collections;
		result.add(root.val);
		result.addAll(right);
		return result;
    }
}
*/