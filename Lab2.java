package university_work;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/* y=e^x the exact value 
   an = a + (n - 1) d the nth element
   1 <= x <= 2 [1 2]
   (b-a)/k k = 10
   therefore the step = 1/10 = 0,1
   so we need all the values like 1,0 1,1 1,2 .... 2
*
*
*/
public class Lab2 {
	static Scanner sc = new Scanner(System.in);
// n in this case = (b-a)/k+1
//	private static final double a = sc.nextDouble();
//	private static final double b = sc.nextDouble();
//	private static final double k = sc.nextDouble();
	static final double a = 1;
	private static final double b = 2;
	static final double k = 0.1;
	static final double e = 0.0001;
	static double y;
	static int n = 15;
	static double [] result = new double [4];
	public static void main(String[] args) {
		System.out.println(n);
		double x = a;
		for (int i = 1; i < n; i++) {
			//y = Math.ceil(Math.exp(x));
			x = x + k;
			System.out.printf("x = %.1f y = %.1f sn = %.4f, se = %.4f%n", x, Helper.calcExactValue(x), Helper.calcApproxValue(x, n), Helper.calcApproxValue(x, e));
		  
		    
		}
//		  System.out.println(Helper.calcExactValue(x));
//		System.out.println("The first method " + Helper.calcApproxValue(x, n));
//		System.out.println("The second method " + Helper.calcApproxValue(x, 0.0001));
		
	
	}

			
}

class Helper {
	public static double calcExactValue(double x) {
		Lab2 lb = new Lab2();
		lb.y = Math.ceil(Math.exp(x));
		return lb.y;
	}

	public static double calcApproxValue(double x, int n) {
		double i, total = 1.0;
		for (i = 1; i < n; i++) {
			total = total + Math.pow(x, i) / fact(i);
		}
		return total;
	}

	// Method to calculate the factorial
	private static double fact(double n) {
		double fact = 1;
		for (int j = 2; j <= n; j++) {
			fact = fact * j;
		}
		return fact;
	}

	/*
	 * C++ reference double myexpo(double x, int n=100) { int k; double sum = 1.0,
	 * pvsum, factorial = 1.0, E = 0.0001; for (k = 1; k <= (n); k++){ // start with
	 * 1 pvsum = sum; factorial *= k; // don't calculate factorial for 0. sum +=
	 * (pow(-x, k)) / factorial;
	 * 
	 * if (k > 1 && fabs(sum - pvsum) < E) { // check if diff is small enough cout
	 * << k << " iterations" << endl; break; // interupt the for loop if it's
	 * precise enough } } return sum; // at the end of the loop sum is the best
	 * approximation }
	 */

	public static double calcApproxValue(double x, double e) {
		int k;
		double sum = 1.0, pvsum, accur = 0.0001;
		for (k = 1; k <= Lab2.n; k++) {
			pvsum = sum;
			sum += (Math.pow(x, k)) / fact(k);

			if (k > 1 && Math.abs(sum - pvsum) <= accur) {
				//System.out.println(k + " iterations");
				break;
			}
		}
		
		return sum;
	}

}