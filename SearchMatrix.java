package com.yifeng.BinarySearch;

/*
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]

given target 3, return true;
*/

public class SearchMatrix {
	/**
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 * use binary search twice. one is to search which row, the other one is to search which column;
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length ==0){
			return false;
		}
		if(matrix[0] == null || matrix[0].length == 0){
			return false;
		}
		
		int row = matrix.length;
		int column = matrix[0].length;
		
		int start = 0;
		int end = row - 1;
		//find the row index which target is on; the last position <= target;
		while(start + 1< end){
			int mid = start + (end - start)/2;
			
			if(matrix[mid][0] == target){
				return true;
			}else if(matrix[mid][0] < target){
				start  = mid;
			}else{
				end = mid;
			}
		}
		
		if(matrix[end][0] <= target){//the target must be on this row.
			row = end;
		} else if(matrix[start][0] <= target){//or must be on this row.
			row = start;
		} else{
			return false;
		}
		// find column index on which the target is at, then the absolute position of target is confirmed;
		start = 0;
		end = column - 1; 
		
		while(start + 1< end){
			int mid = start + (end - start)/2;
			
			if(matrix[row][mid] == target){
				return true;
			} else if(matrix[row][mid] < target){
				start = mid;
			} else{
				end = mid;
			}
		}
		
		if(matrix[row][start] == target){
			return true;
		} else if(matrix[row][end] == target){
			return true;
		} else{
			return false;
		}

	}
}
