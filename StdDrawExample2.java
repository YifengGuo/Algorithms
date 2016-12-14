
public class StdDrawExample2 {

	public static void main(String[] args) {
		int n = 100;
		StdDraw.setXscale(0, n);
		StdDraw.setYscale(0,n*n);
		StdDraw.setPenRadius(0.01);
		for(int i = 0;i<=n;i++){
			StdDraw.point(i, i); 
			StdDraw.point(i, i*i);
			StdDraw.point(i, i*Math.log(i));
		}
	}

}
