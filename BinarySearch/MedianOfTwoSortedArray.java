package com.yifeng.BinarySearch;

/**
 * 
 * @author guoyifeng
 *实际上是一个find kth element in two sorted array的问题; 
 *在A,B数组中分别找第k／2个数，比较A[start ＋ k/2-1] 和 B[start + k/2 -1]的大小；
 *如果B[start + k/2 -1]更大，说明中位数不可能在A[start ＋ k/2-1]之前的数中，其之前的数可删去,为了满足时间复杂度,直接更改start_A的值调整到start_A + k/2;
 *之前删去了其中一个数组中k/2个数，则现在剩下的所有数如果看作一个排序好的数组的话，中位数是第k-k/2个数；
 *递归条件有几个实际的参数则判断几个条件；
 *当k==1时，已经删无可删，应跳出递归
 */
public class MedianOfTwoSortedArray {
	public double findMedianSortedArrays(int A[], int B[]) {
		int len = A.length + B.length;
		// when elements of two array are odd:
		if(len % 2 == 1){
			return findKth(A, 0, B, 0, len/2+1);
		}else {//even:
			return (findKth(A, 0, B, 0, len/2) + findKth(A, 0, B, 0, len/2+1)) / 2.0;
		}

	}

	public int findKth(int[] A, int start_A, int[] B, int start_B, int k) {
		if (start_A >= A.length) {//start_A may be different value in different iteration. So compare start_A with A.length to judge if array out of bound;
			return B[start_B + k - 1];
		}

		if (start_B >= B.length) {
			return A[start_A + k - 1];
		}

		if (k == 1) {
			return Math.min(A[start_A], B[start_B]);
		}

		int A_Key = start_A + k / 2 - 1 < A.length ? A[start_A + k / 2 - 1] : Integer.MAX_VALUE;//假设B.length >> A.length，
																								//则A中不一定有k/2个值，所以必须删B的，所以要保证A_key 一定大于 B_key;

		int B_Key = start_B + k / 2 - 1 < B.length ? B[start_B + k / 2 - 1] : Integer.MAX_VALUE;

		if (A_Key < B_Key) {
			return findKth(A, start_A + k / 2, B, start_B, k - k / 2);//下一次递归是找第k-k/2个数，因为上一次递归删去了不可能的k/2个数；中位数就成为了第k-k/2个数；
		} else {
			return findKth(A, start_A, B, start_B + k / 2, k - k / 2);
		}
	}
}
