import org.junit.*;
import static org.junit.Assert.*;

public class BasicMathTest {
		
	static double input1 = 1.0;
	
	@Test
	public void testBasicMath()
		throws Exception {
		BasicMath result = new BasicMath();
		assertNotNull(result);
		}

	@Test
	public void testABS_1()
		throws Exception {
		double result = BasicMath.ABS(input1);
		assertEquals(1.0, result, 0.1);
	}

	@Test
	public void testABS_AtMinimumValueOfDouble()
		throws Exception {
		double input2 = -4.9E-324;
		double result = BasicMath.ABS(input2);
		assertEquals(Double.MIN_VALUE, result, 0.001);
	}

	@Test
	public void testCos_1()
		throws Exception {
		double result = BasicMath.Cos(input1);
		assertEquals(0.540302305868, result, 0.1);
	}
	
	@Test
	public void testCos_2()
		throws Exception {
		double result = BasicMath.Cos(input1);
		Assert.assertNotEquals(1.55, result, 0.1);
	}

	@Test  
	public void testCos_3()
		throws Exception {
		double input2 = 3.0;
		double result = BasicMath.Cos(input2);
		assertEquals(-0.9899924966, result, 1.0);
	}

	@Test
	public void testCos_4_UsingCeil()
		throws Exception {
		double result = BasicMath.Cos(input1);
		assertEquals(1.0, Math.ceil(result), 0.1);
	}
	
	@Test  
	public void testCos_5_ForNegativeValue()
		throws Exception {
		double input2 = -1.0;
		double result = BasicMath.Cos(input2);
		assertEquals(0.54030230586, result, 0.1);
	}
	
	@Test
	public void testFactorial_1()
		throws Exception {
		int input2 = 0;
		int result = BasicMath.Factorial(input2);
		assertEquals(1, result);
	}

	@Test
	public void testFactorial_2()
		throws Exception {
		int input2 = 10;
		int result = BasicMath.Factorial(input2);
		assertEquals(3628800, result);
	}

	@Test (expected = StackOverflowError.class)
	public void testFactorial_3_ForNegativeValue()
		throws Exception {
		int input2 = -12;
		BasicMath.Factorial(input2);
	}

	
	@Test
	public void testPI_1()
		throws Exception {
		double result = BasicMath.PI();
		assertNotEquals(2, result,0.0);
	}

	
	@Test 
	public void testPI_2()
		throws Exception {
		double expected = 3.14159265359;
		double result = BasicMath.PI();
		assertEquals(expected,result, 0.001);
	}

	@Test
	public void testPower_1()
		throws Exception {
		double Base = input1;
		int Exp = 1;
		double result = BasicMath.Power(Base, Exp);
		assertEquals(1.0, result, 0.0);
	}

	@Test
	public void testPower_2()
		throws Exception {
		double Base = 11.0;
		int Exp = 6;
		double result = BasicMath.Power(Base, Exp);
		assertEquals(1771561, result, 0.0);
	}

	@Test
	public void testPower_3_ForNegativeBaseValue()
		throws Exception {
		double Base = -11.0;
		int Exp = 6;
		double result = BasicMath.Power(Base, Exp);
		assertEquals(1771561, result, 0.0);
	}

	@Test
	public void testPower_4_ForNegativeExponential()
		throws Exception {
		double Base = 11.0;
		int Exp = -6;
		double result = BasicMath.Power(Base, Exp);
		assertEquals(5.6447393e-7, result, 0.0);
	}
	
	@Test
	public void testPower_5_ForNegativeValuesOfBaseAndExponential()
		throws Exception {
		double Base = -11.0;
		int Exp = -6;
		double result = BasicMath.Power(Base, Exp);
		assertEquals(5.6447393e-7, result, 0.0);
	}
	
	@Test
	public void testSin_1()
		throws Exception {
		double result = BasicMath.Sin(input1);
		assertEquals(0.8414709848, result, 0.00001);
	}

	@Test
	public void testSin_2()
		throws Exception {
		double input2 = 2.30991;
		double result = BasicMath.Sin(input2);
		assertEquals(0.73906590803, result, 0.2);
	}

	@Test
	public void testSin_3()
		throws Exception {
		double input2 = 3.0;
		double result = BasicMath.Sin(input2);
		assertEquals(0.14112000806, result, 0.5);
	}
	
	@Test
	public void testSin_4_ForNeagtiveValue()
		throws Exception {
		double input2 = -2.0;
		double result = BasicMath.Sin(input2);
		assertEquals(-0.90929742682, result, 0.01);
	}
	
}


