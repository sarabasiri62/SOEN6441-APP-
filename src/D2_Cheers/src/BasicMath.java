/**
 * @author sara basiri
 * <p>
 * BasicMath class includes some basic math functions (Sin, Cos, Power, Factorial, Sqrt, ABS and PI). 
 * These basic functions are used by Solution class. As the values calculated through Sin, Cos and PI 
 * are using infinite series, so  * a precision should be defined as a boundary in loops. So this class
 * has a private value of PRECISION;
 * 
 *  
 */

public class BasicMath {
	/**
	 * PRECISION is defined here to be used as an upper bound in the loops. 
	 * 
	 */
	
	private static int PRECISION=9; 
		
	
	
	/**
	 * <p> 
	 * compute sinuous of a number in radiance. 
	 * <p>
	 * This function gets an input of type double which is the angle of two line in radiance format.
	 * In order to calculate the sinuous of Input, this function is using the McLaurin  series:
	 * sin(x)=x-(power(x,3)/3!)+(power(x,5)/5!)-.... 
	 * 
	 * 
	 * @param input of type double.
	 * @return result of type double.
	 */
	
	public static double sin(double input) { 
		/**
		 * the initial value of result is equal to input. 
		 */
		double result = input;
		for (int i = 1; i <= PRECISION; i++) {
	        if (i % 2 == 0) 
	        	result += power(input, 2*i+1) / factorial(2 * i + 1);
	        else 
	        	result -= power(input, 2*i+1) / factorial(2 * i + 1);
	       
	    }
		return result;
	}
	
	
	/**
	 * <p> 
	 * computes the co-sinuous of a number in radiance. 
	 * <p>
	 * This function gets an input of type double which is the angle of two line in radiance format.
	 * In order to calculate the cosinuous of Input, this function is using the McLaurin's series:
	 * cos(x)=1-(power(x,2)/2!)+(power(x,4)/4!)-.... 
	 * 
	 * @param input of type double.
	 * @return result of type double.
	 */
	
	public static double cos(double input) { 
		/**
		 * The initial value of result is 1. 
		 */
		double result = 1;
		for (int i = 1; i <= PRECISION; i++) {
	        if (i % 2 == 0) 
	        	result += power(input, 2*i) / factorial(2 * i);
	        else 
	        	result -= power(input, 2*i) / factorial(2 * i);
	    	    }
		return result;
	}
	
	
	/**
	 * <p>
	 * calculates the value of pi
	 * <p>
	 * This function is used to calculate the value of PI. It is using Nilakantha's Series 
	 * to get the value of PI:  PI=3+4/2*3*4-4/4*5*6+...
	 * 
	 * @param no params.
	 * @return pi of type double. 
	 */
	
	public static double pi(){
		/**
		 * n is used as upper bound of the loop. 
		 */
		double n=power(10,5);
		/**
		 * sign is used as the sign of each term in the PI formula. 
		 */
		double sign=1;
		/**
		 * temp is used to hold the template results during the loop. The initial value of temp is 0. 
		 */
		double temp=0;
		/**
		 * The final amount is saved in pi and this would be the return value of the function. 
		 */
		double pi=0;
		for(double i=2;i<=n;i+=2){
			temp=temp+sign*(1/(i*(i+1)*(i+2)));
			sign*=-1;
		}
		pi=3+(4*temp);
		return pi;
	}

	
    /**
     * <p> 
     * calculates the factorial of an integer number. 
     * <p>
     * This function is calculating the factorial of an integer number: n!=n*(n-1)!;
     * This function is using recursion for computing the factorial. 
     * 
     * @param Input of type integer. 
     * @return the factorial of the input.  
     */
	public static int factorial(int Input){
		if(Input==0 || Input==1)
			return 1; 
		else return Input*factorial(Input-1);
		
	}
	
	/**
	 * <p>
	 * computes the value of base to the power of exp.
	 * <p>
	 * This functions gets two integer numbers (Base and Exp) and returns the value of 
	 * Base to the power of Exp; 
	 * 
	 * @param base of type double.
	 * @param exp of type integer. 
	 * @return result of base to the power of exp of type double. 
	 */
	public static double power(double base,int exp){
		/**
		 * The initial value for result should be 1. 
		 */
		double result=1;
		for(int i=0;i<exp;i++){
			result*=base;
			
		}
		return result; 
	}


	/**
	 * <p>
	 * computes the absolute value of a value. 
	 * <p>
	 * This function gets an input of type double and returns its absolute value.
	 * 
	 * @param input of type double. 
	 * @return input if input>0 or -input if input<0. 
	 */
	public static double abs(double input){
		if (input>0)
			return input;
		else
			return -input;
	}
	public static void main(String[] args){
		System.out.println(sin(90));
		System.out.println(cos(90));
	}
	
}
