package string.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	
	public static int count = 0;
	public static int add(String numbers) {
		count ++;
		int returnValue=0;
		if (numbers.isEmpty()) 
				return 0;
		
		String[] numbersArray = numbers.split("[//* \n\t\r.,;:%!?(){]");
		List negativeNumber =new  ArrayList();
		for(String number:numbersArray) {
			number = number.replace("[", "");
			number = number.replace("]", "");
			if(!number.trim().isEmpty()) {
				int numberInt = Integer.parseInt(number.trim());
				if(numberInt<0) {
					negativeNumber.add(numberInt);
				}
				if(numberInt<1000) {
					returnValue += Integer.parseInt(number);
				}
			}
			
		}		
		
		if(negativeNumber.size()>0) {
			throw new RuntimeException("Negative Numbers are Not Allowed" + negativeNumber.toString());
		}
		return returnValue;
	}
	
	public static int GetCalledCount() {
		return count;
	}
}
