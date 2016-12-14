package Fundamental;

import java.util.Random;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercises1113 {

	public static void main(String[] args) {
		int m = 5;
		int n = 5;
		int[][] a = new int[m][n];
		int[][] b = new int[n][m];
		
		a = RandomInitial(a,n);
		b = MigrateArray(a,b);
		StdOut.println();
		MigratePrint(b);

	}
	
	public static int[][] RandomInitial(int[][] a,int N){
		StdOut.println("Initialize the 2-dimentional array.");
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j<a[0].length; j++){
				a[i][j] = StdRandom.uniform(N);
				StdOut.print(a[i][j] + " ");
			}
			StdOut.println();
		}
		return a;
	}
	
	public static int[][] MigrateArray(int[][] a, int[][] b){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j<a[0].length; j++){
				b[j][i] = a[i][j];
			}
		}
		return b;
	}
	public static int[][] MigratePrint(int[][] a){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j<a[0].length; j++){
				StdOut.print(a[i][j] + " ");
			}
			StdOut.println();
		}
		return a;
	}
}
