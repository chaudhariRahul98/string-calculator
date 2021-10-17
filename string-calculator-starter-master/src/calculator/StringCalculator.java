package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String input) {
    	int returnValue = 0;
    	String delimiter = ",|n";
        String numbersWithoutDelimiter = input;
        List negative = new ArrayList();
    	if(input.isEmpty()) {
    		return returnValue;
    	}else if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("//") + 2;
            delimiter = input.substring(delimiterIndex, delimiterIndex + 1);
            numbersWithoutDelimiter = input.substring(input.indexOf("n") + 1);
            return delimiter(numbersWithoutDelimiter, delimiter);
        }else if (input.contains(",")||input.contains("/n")){
    		String[] numbersArray = input.split(",|/n");
    		for (String string : numbersArray) {
    			int num =Integer.parseInt(string);
    			if(num < 0) {
    				negative.add(num);
    			}else if (num <= 1000) {
    				returnValue +=  num ;
    			}
    			
    		}
    	} else {
    		return Integer.parseInt(input);
    	}
    	if(negative.size() >0) {
    		throw new RuntimeException("Negatives not allowed: "+negative.toString());
    	}
    	return returnValue;	
    }
    private static int delimiter(final String input, final String delimiter) {
        int returnValue = 0;
        String[] numbersArray = input.split(delimiter);
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                returnValue += Integer.parseInt(number.trim());
            }
        }
        return returnValue;
    }

}