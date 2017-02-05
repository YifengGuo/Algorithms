package com.yifeng.BinarySearch;

public class FindSqrtOfX {
	public int sqrt(int x) {
		long start = 1;
		long end = x;
		while (start + 1 < end) {
			long mid = start + (end - start) / 2;
			if (mid * mid == x) {
				end = mid;
			} else if (mid * mid < x) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (end * end <= x) {
			return (int) end;
		} else if (start * start <= x) {
			return (int) start;
		} else {
			return -1;
		}

	}
}
