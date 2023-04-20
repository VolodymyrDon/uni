package university_work;

import java.util.Arrays;

public class Lab1 {
	private static double CM_INCH = 0.393701;
	private static double CM_FEET = 0.0328084;
	private static double x = 128;
	
	public static void main(String[] args) {
		System.out.println("The group is: 122-21-1з\nDon V.Y\nTask number: 5\n");
		
		double[] result = convert(x, CM_INCH, CM_FEET);
		System.out.printf(" Length in cm: %f%n Length in inches: %f%n Length in feet: %f", result[0], result[1], result[2]);
	}
	public static double[] convert(double val1, double val2, double val3) {
		double[] output = new double[3];
		
		output[0] = val1;
		output[1] = val1 * val2;
		output[2] = val1 * val3;
		
		
		return output;
		
	}
}
