import static org.junit.Assert.*;

import org.junit.Test;

public class findMaxNumberTest {

	@Test
	public void testFindMaxNumber() {
		MaxNumberModel maxNumber = new MaxNumberModel();
		maxNumber.findMaxNumber(1, 2, 7);
		int result = maxNumber.getMaxNumber();
		assertEquals(7, result);
		
	}

}
