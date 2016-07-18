
public class BasicMath {
	
	public static int PRECISION=10;
	
	public static double Sin(double x) { // X is Radiance
		double rad = x;
		double result = rad;
		for (int i = 1; i <= PRECISION; i++) {
	        if (i % 2 == 0) 
	        	result += Power(rad, 2*i+1) / Factorial(2 * i + 1);
	        else 
	        	result -= Power(rad, 2*i+1) / Factorial(2 * i + 1);
	       
	    }
		return result;
	}
	
	public static double Cos(double x) { // X is Radiance
		double rad = x;
		double result = 1;
		for (int i = 1; i <= PRECISION; i++) {
	        if (i % 2 == 0) 
	        	result += Power(rad, 2*i) / Factorial(2 * i);
	        else 
	        	result -= Power(rad, 2*i) / Factorial(2 * i);
	    	    }
		return result;
	}
	
	public static double PI(){
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
		   
		return pi;
	}

	
	public static int Factorial(int n){
		if(n==0 || n==1)
			return 1; 
		else return n*Factorial(n-1);
		
	}
	public static double Power(double x,int y){
		double result=1;
		for(int i=0;i<y;i++){
			result*=x;
			
		}
		return result; 
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
	public static double ABS(double x){
		if (x>0)
			return x;
		else
			return -x;
	}

}
