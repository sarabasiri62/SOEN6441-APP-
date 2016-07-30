package cheers;
/**
 * @author sarthak batra
 * 
 * Solution class includes functions calculate_Alpha and calculate_Length which implement the formulas provided to us. 
 * These are to calculate the value of alpha(x) which is later used to find out the value of length(l).  
 * The formulas in this class are using java inbuilt mathematics library (i.e Math) for functions like sin, cos, pi and power.
 */
public class Solution {
	
	public static double alpha_Guess=2;						//first guess of alpha as '2'
	public static double pi=Math.PI;      					// value of pi :  3.14159265358979323846

/**
* 	This function is using the formula x-sin(x) = PI/2 to calculate the value of x(alpha), which is the angle of two line in radiance.  
*/
 	public static double calculate_Alpha()
	{
		double delta_Value=Math.abs(alpha_Guess-Math.sin(alpha_Guess)-pi/2);
		while(delta_Value>1/Math.pow(10,10)) 
		{
			alpha_Guess -= (alpha_Guess - Math.sin(alpha_Guess) - pi/2) / (1 - Math.cos(alpha_Guess));	
			delta_Value = Math.abs(alpha_Guess - Math.sin(alpha_Guess) - pi/2);
					
		}
		return alpha_Guess;
	}				//end of calculate_Alpha

	
/**
*This function is using 2*R(1-cos(x/2)) to calculate the value of l(length). 
*'x' is the angle which has been calculated by function calculate_Alpha and 'R' is the radius of the circle.
*/
	public static double calculate_Length(double Radius)
	{
		double alpha=calculate_Alpha();	
		return 2*Radius*(1-Math.cos(alpha/2));			//implementation of formula : 2*R(1-cos(x/2))			
	}				//end of calculate_Length
	
	
/**
* This function gets the temporary value of alpha from calculate_Alpha and returns its absolute value.
*/
	
	
}				//end of Solution
