/* 
 * BasicMath class includes some basic math functions (Sin, Cos, Power, Factorial, Sqrt, ABS and PI). 
 * These basic functions are used by Solution class. As the values calculated through Sin, Cos and PI 
 * are using infinite series, so  * a precision should be defined as a boundary in loops. So this class
 * has a private value of PRECISION;   
 */

public class BasicMath {
	
	private static int PRECISION=10; 
		
	
	
	/* 
	 * This function gets an input of type double which is the angle of two line in radiance format.
	 * In order to calculate the sinuous of Input, this function is using the McLaurin  series:
	 * sin(x)=x-(power(x,3)/3!)+(power(x,5)/5!)-.... 
	 */
	
	public static double Sin(double Input) { 
		
		double result = Input;
		for (int i = 1; i <= PRECISION; i++) {
	        if (i % 2 == 0) 
	        	result += Power(Input, 2*i+1) / Factorial(2 * i + 1);
	        else 
	        	result -= Power(Input, 2*i+1) / Factorial(2 * i + 1);
	       
	    }
		return result;
	}
	
	
	/* 
	 * This function gets an input of type double which is the angle of two line in radiance format.
	 * In order to calculate the cosinuous of Input, this function is using the McLaurin's series:
	 * cos(x)=1-(power(x,2)/2!)+(power(x,4)/4!)-.... 
	 */
	
	public static double Cos(double Input) { 
		
		double result = 1;
		for (int i = 1; i <= PRECISION; i++) {
	        if (i % 2 == 0) 
	        	result += Power(Input, 2*i) / Factorial(2 * i);
	        else 
	        	result -= Power(Input, 2*i) / Factorial(2 * i);
	    	    }
		return result;
	}
	
	
	/*
	 * This function is used to calculate the value of PI. It is using Nilakantha's Series 
	 * to get the value of PI:  PI=3+4/2*3*4-4/4*5*6+...
	 */
	
	public static double PI(){
		
		double n=Power(PRECISION,5);
		double sign=1;
		double Temp=0;
		double PI=0;
		for(double i=2;i<=n;i+=2){
			Temp=Temp+sign*(1/(i*(i+1)*(i+2)));
			sign*=-1;
		}
		PI=3+(4*Temp);
		return PI;
	}

	
    /*
     * This function is calculating the factorial of an integer number: n!=n*(n-1)!;
     */
	public static int Factorial(int Input){
		if(Input==0 || Input==1)
			return 1; 
		else return Input*Factorial(Input-1);
		
	}
	
	/*
	 * This functions gets two integer numbers (Base and Exp) and returns the value of 
	 * Base to the power of Exp; 
	 */
	public static double Power(double Base,int Exp){
		double result=1;
		for(int i=0;i<Exp;i++){
			result*=Base;
			
		}
		return result; 
	}


	/*
	 * ABS gets an input of type double and returns its absolute value.
	 */
	public static double ABS(double Input){
		if (Input>0)
			return Input;
		else
			return -Input;
	}
	
}
