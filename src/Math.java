
public class Math {

	public static double sin(double degree) {

		
		double PI = GetPI();
		int PRECISION=10;

		// angle to radians

		double rad = degree * 1. / 180. * PI;

		// the first element of the taylor series

		/*double sum = rad;

		// add them up until a certain precision (eg. 10)

		for (int i = 1; i<= PRECISION; i++) {

		if (i % 2 == 0)

		sum += pow(rad, 2 * i + 1) / factorial(2 * i + 1);

		else

		sum -= pow(rad, 2 * i + 1) / factorial(2 * i + 1);

		}*/
		
		
		for(int i=0,int j=0;i<PRECISION;i+=2,j++){
			sum+=pow(-1,j)*pow(rad,i+1)/factorial(i+1);
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
		double x; 
		double PI=GetPI();
	    x=Double.MIN_VALUE;
	    //x=1; 
	    x=PI/2+sin(x);
	   // System.out.println(x);
	   double delta=(PI/2+sin(x))-x;
	    System.out.println("delta= "+delta);
	    
	    double temp=0;
	    double px=x;
	    System.out.println("px= "+x);
	    x+=1/pow(10,3);
	    System.out.println("x= "+x);
	    temp=(PI/2+sin(x))-x;
	    System.out.println("temp= "+temp);
	    if(temp<delta){
	    	System.out.println("Yes");
	    	return x;
	    }
	    else {
	    	System.out.println("NO");
	    }
	    	    return px;
	    
			
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

