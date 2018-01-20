import java.text.DecimalFormat;
import java.lang.Math;


public class compoundInterest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat money = new DecimalFormat("$0.00");
		// A = P(1+r/n)^nt
		double P = 10000;
		double r = 0.08;
		double t = 15;
		double n = 1;
		
		
		double done = P*Math.pow((1+r/n),t);
		System.out.print("The value of "+ money.format(P) +" after "+ t +" years gaining "+ r +" interest is "+ money.format(done)+".");
	}

}
