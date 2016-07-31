import org.junit.*;
import static org.junit.Assert.*;

public class SolutionTest {

	@Test
	public void testAlpha_1()
		throws Exception {
		double result = Solution.Alpha();
		assertEquals(2.309881, result, 0.1);
	}

	@Test
	public void testGetLength_1_RadiusWithInRange()
		throws Exception {
		double Radius = 2.0;
		double result = Solution.GetLength(Radius);
		assertEquals(2.384112, result, 0.1);
	}

	@Test
	public void testGetLength_2_AtMaximumValue()
		throws Exception {
		double Radius = 30.00;
		double result = Solution.GetLength(Radius);
		assertEquals(35.7616221779, result, 1.0);
	}

	@Test (expected = Error.class)
	public void testGetLength_3_ForNegativeValue()
		throws Exception {
		double Radius = -1.0;
		Solution.GetLength(Radius);
	}
	
	@Test (expected = Error.class)
	public void testGetLength_4_RadiusNotInRange()
		throws Exception {
		double Radius = 31.00;
		Solution.GetLength(Radius);
	}
	
	@Test
	public void testGetLength_5_RadiusWithDecimalValue()
		throws Exception {
		double Radius = 5.555666;
		double result = Solution.GetLength(Radius);
		assertEquals(6.62265428129, result, 0.2);
	}
	
	@Test
	public void testGetLength_6_RadiusInvolvingMultiplySymbol()
		throws Exception {
		double Radius = 1.0*2;
		double result = Solution.GetLength(Radius);
		assertEquals(2.384112, result, 0.1);
	}
}