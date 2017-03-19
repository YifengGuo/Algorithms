package com.yifeng.BinarySearch;
/*
 *  Given a sorted array and a target value, 
 *  return the index if the target is found. 
 *  If not, return the index where it would be if it were inserted in order.
 *	You may assume NO duplicates in the array.
 *
 *	example
 *	[1,3,5,6], 5 → 2

	[1,3,5,6], 2 → 1

	[1,3,5,6], 7 → 4

	[1,3,5,6], 0 → 0

idea: to find the first position >= target;

 */
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if(A == null || A.length == 0){
			return 0;
		}
		
		int start = 0;
		int end = A.length - 1;
		
		//find the first position of >=target
		while(start + 1 < end){
			int mid = start + (end - start)/2;
			if(A[mid] == target){
				return mid;
			} else if(A[mid] < target){
				start = mid;
			} else{
				end = mid;
			}
		}
		
		if(A[start] >= target){
			return start;
		} else if(A[end] >= target){
			return end;
		} else{//说明target比数组中所有的数都大；
			return A.length ;
		}
    }
}
