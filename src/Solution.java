
public class Solution {
	
	
	public static double alpha;
	public static double FirstGuess=2;
	public static double PI=BasicMath.PI();
	
	
	public static double Alpha(){
		double delta=BasicMath.ABS(FirstGuess-BasicMath.Sin(FirstGuess)-PI/2);
		while(delta>0.000001) {
			FirstGuess -= (FirstGuess - BasicMath.Sin(FirstGuess) - PI/2) / (1 - BasicMath.Cos(FirstGuess));	
			delta = BasicMath.ABS(FirstGuess - BasicMath.Sin(FirstGuess) - PI/2);
					
		}
		return FirstGuess;
	}
	
	public static double GetLength(double Radious){
		double alpha=Alpha();
		return 2*Radious*(1-BasicMath.Cos(alpha/2));
	}
	
	public static void main(String[] args){
		System.out.println("Alpha="+Alpha());
		System.out.println("Length="+GetLength(3));
	}

}
