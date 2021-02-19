package string.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

	public static void main(String[] args) {
		
		org.junit.runner.JUnitCore.main("string.calculator");
	}
		@Test
		public void testEmptyString() {
			Assert.assertEquals(0, StringCalculator.add(""));
		}

		@Test
		public void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
			Assert.assertEquals(2+5+6+8+7+4+3+1,StringCalculator.add("2,5,6,8,7,4,3,1"));
		}
		
		@Test
		public void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
			Assert.assertEquals(3+6+15, StringCalculator.add("3,6\n15"));
		}
		
		@Test
		public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
		    Assert.assertEquals(3+6+15, StringCalculator.add("//;\n3;6;15"));
		}
		
		@Test(expected = RuntimeException.class)
		public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
		    StringCalculator.add("3,-6,15,18,46,33");
		}
		@Test
		public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
		    RuntimeException exception = null;
		    try {
		        StringCalculator.add("3,-6,15,-18,46,33");
		    } catch (RuntimeException e) {
		        exception = e;
		    }
		    Assert.assertNotNull(exception);
		    Assert.assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
		}
		
		
		
		@Test
		public void addMethodCallsCounts() {
			Assert.assertEquals(2, StringCalculator.GetCalledCount());
		}
		
		@Test
		public void numberMoreThen1000ThenIgnored() {
			Assert.assertEquals(3+8+4, StringCalculator.add("3,1002,8,2001,4,1234"));
		}
		
		@Test
		public void delimiters() {
			Assert.assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
		}
		
		
		@Test
		public void allowAllDelimiters() {
			Assert.assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
		}
		
		@Test
		public void multipleDelimiters() {
			Assert.assertEquals(6, StringCalculator.add("//[**][%%]\n1**2%%3"));
		}
}
