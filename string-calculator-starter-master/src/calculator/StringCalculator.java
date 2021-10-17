package calculator;

public class StringCalculator {

    public int add(String input) {
    	int returnValue = 0;
    	if(input.isEmpty()) {
    		return returnValue;
    	}else if (input.contains(",")||input.contains("/n")){
    		String[] numbersArray = input.split(",|/n");
    		for (String string : numbersArray) {
    			int num =Integer.parseInt(string);
    			returnValue +=  num ;
    		}
    	}else {
    		return Integer.parseInt(input);
    	}
    	return returnValue;	
    }
}