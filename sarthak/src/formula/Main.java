package formula;
import java.util.Scanner;

public class Main {
	static double radius=0;
	
	public static void main(String args[]){
		radius_value_input();
		double alpha=Solution.Alpha();
		double length= Solution.GetLength(radius);
		System.out.println("Length : "+length);
		System.out.println("Alpha : "+alpha);
		Xml_file_save.save(radius,length);

	}
		
	 static void radius_value_input(){
		 System.out.println("Enter the Value of Radius (R) : ");
		 radius=0;
		try{    
		 Scanner radius1=new Scanner(System.in);
		 radius=radius1.nextDouble();
		 if(radius<1||radius>30)
		 {
			 System.out.println("ERROR : Value of Radius should be between 1 and 30");
			 radius_value_input();
		 }
		}
		 catch (Exception e) {
	         e.printStackTrace();
	      }
	}
}
