package formula;
import java.util.Scanner;

public class Main {
	static double radius=0;
	
	public static void main(String args[]){
		radius_value_input();
		Double length= Solution.GetLength(radius);
		System.out.println("Length : "+length);
		Xml_file_save.save(radius,length);

	}
		
	 static void radius_value_input(){
		 System.out.println("Enter the Value of Radius (R) : ");
		 radius=0;
		 Scanner radius1=new Scanner(System.in);
		 radius=radius1.nextInt();
		 if(radius<=0)
		 {
			 System.out.println("ERROR : Value of Radius should be more than 0");
			 radius_value_input();
		 }
	}
}
