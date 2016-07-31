import org.junit.*;
import static org.junit.Assert.*;

public class GUITest {

	@Test
	public void testGUI_1_ForGUIMethod()
		throws Exception {
		GUI result = new GUI();
		assertNotNull(result);
	}

}