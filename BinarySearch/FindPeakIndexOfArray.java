package com.yifeng.BinarySearch;
/*
There is an integer array which has the following features:

The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].

We define a position P is a peek if:
A[P] > A[P-1] && A[P] > A[P+1]

Find a peak element in this array. Return the index of the peak.
 
Example

Given [1, 2, 1, 3, 4, 5, 7, 6]
Return index 1 (which is number 2) or 6 (which is number 7)


*/
/**
 * 
 * @author guoyifeng
 *思路：首先判断A[mid]和A[mid - 1]的相对大小来判断是在上坡还是下坡来缩小查找空间;
 */
public class FindPeakIndexOfArray {
	public int findPeak(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;

			if (A[mid] > A[mid - 1]) {
				start = mid;
			} else if (A[mid] < A[mid - 1]) {
				end = mid;
			}
		}

		if (A[start] > A[start + 1] && A[start] > A[start - 1]) {
			return start;
		} else if (A[end] > A[end + 1] && A[end] > A[end - 1]) {
			return end;
		} else {
			return -1;
		}
	}
}
