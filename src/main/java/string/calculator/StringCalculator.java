package string.calculator;

public class StringCalculator {
	
	public static int add(String numbers) {
		
		int returnValue=0;
		if (numbers.isEmpty()) 
				return 0;
		
		String[] numbersArray = numbers.split(",");
			
		for(String number:numbersArray) {
			if(!number.trim().isEmpty()) {
				returnValue += Integer.parseInt(number);
			}
			
		}
		return returnValue;
	}
}
