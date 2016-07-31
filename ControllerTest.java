import org.junit.*;

public class ControllerTest {

	@Test
	public void testRun_1_ToCheckRunMethod()
		throws Exception {
		Controller fixture = new Controller();
		double Radius = 1.0;
		fixture.Run(Radius);
	}

}