package cheers;
/**
 * 
 * @author Sarthak
 *
 */
public class Controller {
	private double length;
	
	public void run(double radius){
		//Solution resultOutput=new Solution();
		length=Solution.calculate_Length(radius);
	}
	
	public double getLength(){
		return length;
	}
	
}
