package cicalc;
<<<<<<< HEAD

=======
>>>>>>> b2185b71075bb877805f87db6831befe3a766484
import java.util.Scanner;
import java.math.BigDecimal;

//this one won't have a GUI component, but will be used by the one that does
public class CompoundInterestCalculator {
	public static double calcAnnual(double P, double r, double Y, double D) { //desired val = D (LOL)
<<<<<<< HEAD
		final double z = r + 1;
		return ((z - 1) * (D - P * Math.pow(z, Y))) / (z * (Math.pow(z, Y) - 1));
	} // mum get the bracketssssssss
	public static double getFutureValue(double P, double r, double Y, double c) { // maybe should use BigDecimal
		final double z = r + 1;
		return P * Math.pow(z, Y) + c * ((Math.pow(z, Y + 1) - z) / (z - 1)); // confirmed casting unnecessary
	} // Where P is the principal; z is 1+r where r is the annual interest rate; c is annual contribution; Y is the number of years

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Give initial deposit, rate (type in the percentage value, like 2 or 5. Remember to omit the percentage symbol), years to mature, and amount added annually");
		double[] inputs = { in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble() }; // cuz fk u I want an array
=======
		final double z = r + 1;  //memory in use to save... like 0 CPU resources :\
		System.out.println("HARSHLYCRITICAL CALC: " + ((z - 1) * (D - P * Math.pow(z, Y)))/(Math.pow(z, Y+1) - z));
		System.out.println("WOLFRAM CALC        : " + ((z - 1) * (D - P * Math.pow(z, Y)))/(z*(Math.pow(z, Y) - 1)));
		//what's the difference..? They both seem to return the same answer. Which is correct?
		return ((z - 1) * (D - P * Math.pow(z, Y)))/(z*(Math.pow(z, Y) - 1)); 
	} //mum get the bracketssssssss
	public static double getFutureValue(double P, double r, double Y, double c) { //maybe should use BigDecimal
		final double z = r + 1;
		return P*Math.pow(z, Y) + c*((Math.pow(z, Y+1) - z)/(z-1)); //confirmed casting unnecessary
	} //Where P is the principal; z is 1+r where r is the annual interest rate; c is annual contribution; Y is the number of years
	/*public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Give initial deposit, rate (type in the percentage value, like 2 or 5. Remember to omit the percentage symbol), years to mature, and amount added annually");
		double[] inputs = {in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble()}; //cuz fk u I want an array
>>>>>>> b2185b71075bb877805f87db6831befe3a766484
		double p = inputs[0];
		double r = inputs[1];
		double y = inputs[2];
		double c = inputs[3];
<<<<<<< HEAD
		r = r / 100;
		System.out.println(r);
		BigDecimal futureValue = new BigDecimal(getFutureValue(p, r, y, c)).setScale(2, BigDecimal.ROUND_HALF_UP); // I could do the whole thing in BigDecimal if I wanted, will do if I have time
		System.out.println("The future value of the deposit is... " + futureValue);

		// annual calc test
		System.out.print("Input the desired value of your investment: ");
		double desired = in.nextDouble();
		BigDecimal annual = new BigDecimal(calcAnnual(p, r, y, desired)).setScale(2, BigDecimal.ROUND_HALF_UP); 
=======
		r = r/100;
		System.out.println(r);
		BigDecimal futureValue = new BigDecimal(getFutureValue(p, r, y, c)).setScale(2, BigDecimal.ROUND_HALF_UP); //I could do the whole thing in BigDecimal if I wanted, will do if I have time
		System.out.println("The future value of the deposit is... " + futureValue);
		
		//annual calc test
		System.out.print("Input the desired value of your investment: ");
		double desired = in.nextDouble();
		BigDecimal annual = new BigDecimal(calcAnnual(p, r, y, desired)).setScale(2, BigDecimal.ROUND_HALF_UP); //this is probably a better use of memory than saving "z = r + 1"
>>>>>>> b2185b71075bb877805f87db6831befe3a766484
		in.close();
		System.out.println("The annual deposit value to get desired value is " + annual);
		BigDecimal desiredFutureValue = new BigDecimal(getFutureValue(p, r, y, annual.doubleValue())).setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println("The future value of the deposit is... " + desiredFutureValue);
<<<<<<< HEAD
	}
=======
	}*/
>>>>>>> b2185b71075bb877805f87db6831befe3a766484
}
