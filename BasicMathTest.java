import org.junit.*;
import static org.junit.Assert.*;

public class BasicMathTest {
	
	@Test
	public void testBasicMath()
		throws Exception {
		BasicMath result = new BasicMath();
		assertNotNull(result);
		}

	@Test
	public void testABS_1()
		throws Exception {
		double Input = 1.0;
		double result = BasicMath.ABS(Input);
		assertEquals(1.0, result, 0.1);
	}

	@Test
	public void testABS_AtMinimumValueOfDouble()
		throws Exception {
		double Input = -4.9E-324;
		double result = BasicMath.ABS(Input);
		assertEquals(Double.MIN_VALUE, result, 0.001);
	}

	@Test
	public void testCos_1()
		throws Exception {
		double Input = 1.0;
		double result = BasicMath.Cos(Input);
		assertEquals(0.540302305868, result, 0.1);
	}
	
	@Test
	public void testCos_2()
		throws Exception {
		double Input = 1.0;
		double result = BasicMath.Cos(Input);
		Assert.assertNotEquals(1.55, result, 0.1);
	}

	@Test  
	public void testCos_3()
		throws Exception {
		double Input = 3.0;
		double result = BasicMath.Cos(Input);
		assertEquals(-0.9899924966, result, 0.1);
	}

	@Test
	public void testCos_04()
		throws Exception {
		double Input = 1.0;
		double result = BasicMath.Cos(Input);
		assertEquals(1.0, Math.ceil(result), 0.1);
	}
	
	@Test
	public void testFactorial_1()
		throws Exception {
		int Input = 0;
		int result = BasicMath.Factorial(Input);
		assertEquals(1, result);
	}

	@Test
	public void testFactorial_2()
		throws Exception {
		int Input = 2;
		int result = BasicMath.Factorial(Input);
		assertEquals(2, result);
	}

	@Test
	public void testFactorial_3()
		throws Exception {
		int Input = 10;
		int result = BasicMath.Factorial(Input);
		assertEquals(3628800, result);
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
		double Base = 1.0;
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
	public void testSin_1()
		throws Exception {
		double Input = 1.0;
		double result = BasicMath.Sin(Input);
		assertEquals(0.8414709848, result, 0.00001);
	}

	@Test
	public void testSin_2()
		throws Exception {
		double Input = 2.30991;
		double result = BasicMath.Sin(Input);
		assertEquals(0.73906590803, result, 0.2);
	}

	@Test
	public void testSin_3()
		throws Exception {
		double Input = 3.0;
		double result = BasicMath.Sin(Input);
		assertEquals(0.14112000806, result, 1.1);
	}
	
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BasicMathTest.class);
	}
}