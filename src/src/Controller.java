/*
 * This class is used as a bridge between GUI class and Solution class. 
 * It has two private attributes for the value of Alpha and Length. To set the values of these 
 * attributes, Run function is calling the methods of the Solution class. In order to other classes 
 * have access to the value of private attributes, two functions (getLength and getAlpha) have been
 * defined.  
 */

public class Controller {
	
	private double Length_Result;
	private double Alpha_Result;
	
	public void Run(double Radius){
		 Length_Result=Solution.GetLength( Radius);
		 Alpha_Result=Solution.Alpha();
	}
	public double getLength(){
		return Length_Result;
	}
	
	public double getAlpha(){
		return Alpha_Result;
	}

}
