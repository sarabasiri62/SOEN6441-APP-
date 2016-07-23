package cheers;
/**

 */
public class Solution {
	
	public static double alpha_Guess=2;
	public static double pi=Math.PI;
	static double radius=0;
	
	public static double calculate_Alpha()
	{
		double delta_Value=abs(alpha_Guess-Math.sin(alpha_Guess)-pi/2);
		while(delta_Value>1/Math.pow(10,10)) 
		{
			alpha_Guess -= (alpha_Guess - Math.sin(alpha_Guess) - pi/2) / (1 - Math.cos(alpha_Guess));	
			delta_Value = abs(alpha_Guess - Math.sin(alpha_Guess) - pi/2);
					
		}
		return alpha_Guess;
	}				//end of calculate_Alpha
	
	public static double calculate_Length(double Radius)
	{
		double alpha=calculate_Alpha();
		return 2*Radius*(1-Math.cos(alpha/2));
	}				//end of calculate_Length
	
	
	public static double abs(double x)
	{
		if (x>0)
			return x;
		else
			return -x;
	}				//end of abs
	
}				//end of Solution
