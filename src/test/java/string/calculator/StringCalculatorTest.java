package string.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	public static void main(String[] args) {
		
		org.junit.runner.JUnitCore.main("string.calculator");
	}
		@Test
		public void testEmptyString() {
			assertEquals(0, StringCalculator.add(""));
		}

}
