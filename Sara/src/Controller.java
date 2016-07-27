/**
 * @author sara basiri. 
 * <p>
 * This class is used as a bridge between GUI class and Solution class. 
 * It has two private attributes for the value of Alpha and Length. To set the values of these 
 * attributes, Run function is calling the methods of the Solution class. In order to other classes 
 * have access to the value of private attributes, two functions (getLength and getAlpha) have been
 * defined.  
 */

public class Controller {
	/**
	 * the value of length is stored in lengthResult. This value then returns by getLength() function. 
	 */
	private double lengthResult;
	/**
	 * the value of alpha is stored in alphaResult. This value then returns by getAlpha() function. 
	 */
	private double alphaResult;
	
	/**
	 * <p>
	 * call the functions of the Solution class to get the results. 
	 * 
	 * @param radius of type double. 
	 * @return no return value. 
	 */
	public void run(double radius){
		 lengthResult=Solution.getLength( radius);
		 alphaResult=Solution.alpha();
	}
	
	/**
	 * <p>
	 * returns the value of length. 
	 * @return lengthResult of type double. 
	 */
	public double getLength(){
		return lengthResult;
	}
	
	/**
	 * <p>
	 * returns the value of alpha. 
	 * @return alphaResult of type double. 
	 */
	
	public double getAlpha(){
		return alphaResult;
	}

}
