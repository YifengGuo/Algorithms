package com.yifeng.BinarySearch;
/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index,
otherwise return -1.

Example
For [4, 5, 1, 2, 3] and target=1, return 2.

For [4, 5, 1, 2, 3] and target=0, return -1.

You may assume no duplicate exists in the array.

*/
/**
 * 
 * @author guoyifeng
 * 思路：两个象限，mid可能在左边图形 也 可能在右边图形；
 * 在左边时，target可能在s－m段或者其他段，只需要考虑target在s-m段二分产生什么，其他情况else
 * 在右边时，target可能在m－s段或者其他段，只需要考虑target在m-e段二分产生什么，其他情况else
 * 
 * 最后判断是在start还是在end取得target然后返回index；
 * 
 */
public class SearchRotatedSortedArray {
	public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;

			// mid is on the left field:
			if (A[mid] > A[end]) {
				if (A[start] <= target && target <= A[mid]) {
					end = mid;
				} else {
					start = mid;
				}
			} else {// mid is on the right side:
				if (A[mid] <= target && target <= A[end]) {
					start = mid;
				} else {
					end = mid;
				}
			}
		}

		if (A[start] == target) {
			return start;
		} else if (A[end] == target) {
			return end;
		} else {
			return -1;
		}
	}
}
