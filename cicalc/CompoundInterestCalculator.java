package cicalc;

//this one won't have a GUI component, but will be used by the one that does
public class CompoundInterestCalculator {
	public double calcAnnual(double D, double P, double Y, double r) { //desired val = D (LOL)
		final double z = r + 1;
		return (double)((z-1)*(D - P * Math.pow(z, Y)))/(Math.pow(z, (Y+1)) - z); //mlg af
	}
	public double getFutureValue(double p, double c, double y, double r) { //maybe should use BigDecimal
		final double z = r + 1; //memory in use to save... like 0 CPU resources
		return (double)(Math.pow(p*z, y) + c*((Math.pow(z, y+1))/(z-1))); //type casting may be detrimental to performance here with no positive impact, but just for safety, y'know?
	} //Where P is the principal; z is 1+r where r is the annual interest rate; 
} //c is annual contribution; Y is the number of years
