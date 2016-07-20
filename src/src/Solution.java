
/*
 * Solution class includes functions (Alpha and Getlength) to calculate the length of the line of
 * overlapping area of two circle with any radius value. 
 * This class is using the functions defined in BasicMath class to calculate Alpha and Length of the 
 * line. 
 */

public class Solution {
	
	
	/*
	 * This function is using x-sin(x)=PI/2 to calculate the value of x which is the angle of two line 
	 * in radiance. 	
	 */
	public static double Alpha(){
		
		double FirstGuess=2; 
		double PI=BasicMath.PI();
		double delta=FirstGuess - BasicMath.Sin(FirstGuess) - PI/2;
		double alpha=FirstGuess;
		
		while(delta<=1/BasicMath.Power(10,3)){
			delta=alpha - BasicMath.Sin(alpha) - PI/2;
			alpha+=1/BasicMath.Power(10,2);	
		}
		
		return alpha;
	}
	
	
	/*
	 * This function is using l=2*R(1-cos(x/2)) to calculate the length of l. x is the angle which has been 
	 * calculated by Alpha function and R is the radius of the circles. 
	 */
	public static double GetLength(double Radius){
		double alpha=Alpha();
		return 2*Radius*(1-BasicMath.Cos(alpha/2));
	}
	
}
