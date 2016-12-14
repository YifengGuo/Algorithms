import java.util.*;
public class BinarySearch {
	
	public static int indexOf(int[] a,int key){
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi){
			int mid = lo + (lo + hi)/2;
			if(key == mid) return mid;
			else if(key < mid) hi = mid - 1;
			else if(key > mid) lo = mid + 1;
		}
		return -1;
	}
	public static void main(String[] args) {
		In in = new In(args[0]);
		int[] whitelist = in.readAllInts();
		Arrays.sort(whitelist);
		
		while(!StdIn.isEmpty()){
			int key = StdIn.readInt();
			if(indexOf(whitelist,key) == -1){
				StdOut.println(key);
			}
		}
	}

}
