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
}
