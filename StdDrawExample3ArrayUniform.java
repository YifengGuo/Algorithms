import java.util.Arrays;

public class StdDrawExample3ArrayUniform {
	public static void main(String[] main){
		int n = 50;
		double[] a = new double[n];
		for(int i = 0;i < n;i++){
			a[i] = StdRandom.uniform();
		}
		Arrays.sort(a);
		for(int i = 0;i < n;i++){
			double x = 1.0*i/n;
			double y = a[i]/2.0;
			double rw = 0.5/n;
			double rh = a[i]/2.0;
			StdDraw.filledRectangle(x, y, rw,rh);
		}
	}
}
