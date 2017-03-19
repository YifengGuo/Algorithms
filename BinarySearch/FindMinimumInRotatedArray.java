package com.yifeng.BinarySearch;
/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Example
Given [4, 5, 6, 7, 0, 1, 2] return 0

Find the minimum element.

*/
public class FindMinimumInRotatedArray {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int start = 0;
		int end = nums.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] >= nums[end]) {
				start = mid;
			} else {
				end = mid;
			}

		}

		if (nums[start] > nums[end]) {
			return nums[end];
		} else {
			return nums[start];
		}
	}
}
