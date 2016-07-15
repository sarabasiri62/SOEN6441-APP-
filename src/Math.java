
public class Math {

	public static double sin(double degree) {

		//Math m=new Math();
		double PI = GetPI();
		int PRECISION=10;

		// angle to radians

		double rad = degree * 1. / 180. * PI;

		// the first element of the taylor series

		double sum = rad;

		// add them up until a certain precision (eg. 10)

		for (int i = 1; i<= PRECISION; i++) {

		if (i % 2 == 0)

		sum += pow(rad, 2 * i + 1) / factorial(2 * i + 1);

		else

		sum -= pow(rad, 2 * i + 1) / factorial(2 * i + 1);

		}

		return sum;

		}
	public static double cos(double degree) {

		int PRECISION = 10;
		double PI=GetPI();

		// angle to radians

		double rad = degree * 1. / 180. *PI;

		// the first element of the taylor series

		double sum = 1;

		// add them up until a certain precision (eg. 10)

		for (int i = 1; i<= PRECISION; i++) {

		if (i % 2 == 0)

		sum += pow(rad, 2 * i) / factorial(2 * i);

		else

		sum -= pow(rad, 2 * i) / factorial(2 * i);

		}

		return sum;

		}
	public static int factorial(int n){
		if(n==0 || n==1)
			return 1; 
		else return n*factorial(n-1);
		
	}
	public static double pow(double x,int y){
		double result=1;
		for(int i=0;i<y;i++){
			result*=x;
			
		}
		return result; 
	}
	
	public static double length(double Radious){
		
		return 0;
	}
	public static double angle(){
		double a=0;
		Math m=new Math();
		double PI=GetPI();
		double rad = 0;
		System.out.println("Starting...");
		
		while(a<=180){
			rad = a * 1. / 180. * PI;
			if (rad-m.sin(a)==PI/2){
				return a;
				
			}
			else a+=0.00001; 
		}
		System.out.println("not found");
		return 0;
		
	}
	
	public static double GetPI(){
		double pi=1;
		double f; 
		int n=1000;
		 for(int i = n; i > 1; i--) {
		      f = 2;
		      for(int j = 1; j < i; j++){
		         f = 2 + sqrt(f);
		      }
		      f = sqrt(f);
		      pi = pi * f / 2;
		   }
		   pi *= sqrt(2) / 2;
		   pi = 2 / pi;
		   
		   //System.out.println("\nAproximated value of PI =  "+pi); 
		   return pi;

	}
	public static double sqrt(double fg) {

		double n = ((1 + fg) / 2.0);

		double lstX = 0.0;

		while (n != lstX) {

		lstX = n;

		n = (n + fg / n) / 2.0;

		}

		return n;

		}
	
	public static void main(String[] args){
		Math m=new Math();
		System.out.println(m.factorial(5));
		System.out.println(m.pow(3, 2));
		System.out.println(m.sin(90));
		System.out.println(m.cos(90));
		System.out.println(m.GetPI());
		System.out.println(m.angle());
		
	}
}

