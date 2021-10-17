package calculator;

import org.junit.*;

import static org.junit.Assert.*;

public class StringCalculatorShould {

    @Test
    public void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }
    @Test
    public void string_with_two_number_should_return_number_as_int() {
    	StringCalculator stringCalculator = new StringCalculator();
    	 assertEquals(3, stringCalculator.add("1,2"));
    }
    @Test
    public void string_with_more_than_two_number_should_return_number_as_int() {
    	StringCalculator stringCalculator = new StringCalculator();
        assertEquals(10, stringCalculator.add("1,2,3,4"));
    }
    @Test
    public void string_with_new_lines_between_two_number_should_return_number_as_int() {
    	StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1/n2,3"));
    }
    @Test
    public void string_with_delimiters_number_should_return_number_as_int() {
    	StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("//;/n1;2"));
    }
    
    @Test(expected = RuntimeException.class)
    public final void string_with_negative_number_is_give_RuntimeException() {
    	StringCalculator stringCalculator = new StringCalculator();
    	stringCalculator.add("1,-2,3");
    }
    @Test
    public final void string_with_negative_number_is_give_RuntimeExceptionMessage_with_negative_number() {
    	StringCalculator stringCalculator = new StringCalculator();
    	RuntimeException exception = null;
        try {
            stringCalculator.add("1,-2,3,-4");
        } catch (RuntimeException e) {
            exception = e;
        }
        Assert.assertEquals("Negatives not allowed: [-2, -4]", exception.getMessage());
    }
}
