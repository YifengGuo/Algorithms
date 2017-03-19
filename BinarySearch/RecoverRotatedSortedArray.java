package com.yifeng.BinarySearch;

/*
Example
[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5] 
*/
import java.util.ArrayList;

public class RecoverRotatedSortedArray {
	
	public void reverse(ArrayList<Integer> nums, int start,int end){
		for(int i = start, j = end; i < j; i++,j--){
			int temp = nums.get(i);
			nums.set(i, nums.get(j));
			nums.set(j, temp);
		}
	}

	public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
		for(int i = 0; i < nums.size() - 1; i++){// i+1 will be used,so i+1 < nums.size();
			if(nums.get(i) > nums.get(i + 1)){//find the rotated point;
				reverse(nums,0,i);
				reverse(nums,i+1,nums.size() - 1);
				reverse(nums,0,nums.size() - 1);
			}
		}
    }
}
