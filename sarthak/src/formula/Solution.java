package formula;
public class Solution {
	
	
	public static double FirstGuess=2;
	public static double PI=Math.PI;
	
	
	public static double Alpha(){
		double delta=ABS(FirstGuess-Math.sin(FirstGuess)-PI/2);
		while(delta>1/Math.pow(10,10)) {
			FirstGuess -= (FirstGuess - Math.sin(FirstGuess) - PI/2) / (1 - Math.cos(FirstGuess));	
			delta = ABS(FirstGuess - Math.sin(FirstGuess) - PI/2);
					
		}
		return FirstGuess;
	}
	
	public static double GetLength(double Radius){
		double alpha=Alpha();
		return 2*Radius*(1-Math.cos(alpha/2));
	}
	
	
	public static double ABS(double x){
		if (x>0)
			return x;
		else
			return -x;
	}
}
