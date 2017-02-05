package com.yifeng.BinarySearch;
/*
Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.
[
 [1, 3, 5, 7],
 [2, 4, 7, 8],
 [3, 5, 9, 10]
]
Given target = 3, return 2.
*/

public class SearchMatrixTwo {
	/*
	 * 思路:从左下角开始找，当前位置==target，则当前列和当前行都不会存在第二个target；
	 * 如果左下位置小于target，则当前列排除，列++，行不变判断下一个位置
	 * 如果左下位置大于target，则当前行排除，行--，列不变判断下一个位置
	 */
	public int searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0){
			return 0;
		}
		if(matrix[0] == null || matrix[0].length == 0){
			return 0;
		}
		
		int row = matrix.length;
		int column = matrix[0].length;
		int x = row - 1;//the last row;
		int y = 0;//the first column;
		int count = 0;//occurrence
		
		while(x >= 0 && y < column){//must be in the matrix
			if(matrix[x][y] == target){
				x--;
				y++;
				count++;
			} else if(matrix[x][y] < target){
				y++;
			} else{
				x--;
			}
		}
		return count;
		
	}
}
