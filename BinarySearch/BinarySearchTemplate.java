package com.yifeng.BinarySearch;

public class BinarySearchTemplate {
	/*
	 * two logic blocks
	 * the first one is to shrink the search interval
	 * the second one is to find the target; 
	 */
	public int BinarySearch(int[] nums,int target){
		if(nums == null || nums.length == 0){
			return -1;
		}
		
		int start = 0;
		int end = nums.length - 1;//two points;
		
		/*
		 * start + 1 < end limits intersection and adjacent will 
		 * end the loop
		 * only one or two number(s) will be left to choose;
		 * 
		 * aim to shrink the array
		 */
		while(start + 1 < end){
			int mid = start + (end - start) / 2;//to avoid stark overflow,because start + end may have chance > integer range;
			
			if(target == nums[mid]){
				end = mid;
			} else if(target > nums[mid]){
				start = mid;
			} else{
				end = mid;
			}
		}
		/*
		 * if while loop ends with two numbers,
		 * estimate which one equals target and return it;
		 */
		if(nums[end] == target){
			return end;
		}
		if(nums[start] == target){
			return start;
		}
		//if no number in array equals with target,return -1;
		return -1;
	}
}
