
/**
 * @author sara basiri
 * <p>
 * Solution class includes functions (Alpha and Getlength) to calculate the length of the line of
 * overlapping area of two circle with any radius value. 
 * This class is using the functions defined in BasicMath class to calculate Alpha and Length of the 
 * line. 
 */

public class Solution {
	
	
	/**
	 * <p>
	 * computes the value of alpha.
	 * <p>
	 * This function is using x-sin(x)=PI/2 to calculate the value of x which is the angle of two line 
	 * in radiance.
	 * 
	 *  @param no param. 
	 *  @return alpha of type double. 	
	 */
	public static double alpha(){
		/**
		 * The value of firstGuss has been computed manually and approximately equals to 2. 
		 */
		double firstGuess=2; 
		/**
		 * pi is calculated by pi() function from BasicMath class. 
		 */
		double pi=BasicMath.pi();
		/**
		 * the goal is to get delta very close to 0. as the values are not exact values,
		 *  in the best case delta gets <= threshold.
		 * Threshold here is 0.001  
		 */
		double delta=firstGuess - BasicMath.sin(firstGuess) - pi/2;
		
		/**
		 * The initial value for alpha is equal to firstGuss. alpha is increasing in a loop until delta gets smaller than 
		 * threshold. 
		 */
		double alpha=firstGuess;
		
		while(delta<=1/BasicMath.power(10,3)){
			delta=alpha - BasicMath.sin(alpha) - pi/2;
			alpha+=1/BasicMath.power(10,2);	
		}
		
		return alpha;
	}
	
	
	/**
	 * <P>
	 * computes the length of the overlapping area between two circles. 
	 * <p>	 
	 * This function is using l=2*R(1-cos(x/2)) to calculate the length of l. x is the angle which has been 
	 * calculated by Alpha function and R is the radius of the circles. 
	 * 
	 * @param radius of type double. 
	 * @return the amount of 2*radius*(1-BasicMath.cos(alpha/2)) which is a number of type double. 
	 */
	public static double getLength(double radius){
		/**
		 * alpha is the angle which is computed by alpha() function from BasicMath class. 
		 */
		double alpha=alpha();
		return 2*radius*(1-BasicMath.cos(alpha/2));
	}
	
}
