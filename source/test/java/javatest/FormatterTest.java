package javatest;

import static org.junit.Assert.assertEquals;
//import java.util.Formatter;
import org.junit.Test;

public class FormatterTest
{
    @Test
    public void test_string_default() {
        assertEquals("ab 123 あいう 123", String.format("%1$s %2$s %3$s %2$s", "ab", "123", "あいう"));
    }

    @Test
    public void test_string_padded() {
        assertEquals("|  ab| 123| あいう|", String.format("|%1$4s|%2$4s|%3$4s|", "ab", "123", "あいう"));
    }

    @Test
    public void test_string_left_aligned() {
        assertEquals("|ab  |123 |あいう |", String.format("|%1$-4s|%2$-4s|%3$-4s|", "ab", "123", "あいう"));
    }

    @Test
    public void test_integer_padded() {
        assertEquals("|  12| -12| 123|-123|12345|-12345|", String.format("|%1$4d|%2$4d|%3$4d|%4$4d|%5$4d|%6$4d|", 12, -12, 123, -123, 12345, -12345));
    }

    @Test
    public void test_integer_padded_with_sign_space() {
        assertEquals("|  12| -12| 123|-123| 12345|-12345|", String.format("|%1$ 4d|%2$ 4d|%3$ 4d|%4$ 4d|%5$ 4d|%6$ 4d|", 12, -12, 123, -123, 12345, -12345));
    }

    @Test
    public void test_integer_padded_with_zero() {
        assertEquals("|0012|-012|0123|-123|12345|-12345|", String.format("|%1$04d|%2$04d|%3$04d|%4$04d|%5$04d|%6$04d|", 12, -12, 123, -123, 12345, -12345));
    }

    @Test(expected = java.util.IllegalFormatConversionException.class)
    public void test_integer_supplying_string_args() {
        assertEquals("|  12| -12| 123|-123|12345|-12345|", String.format("|%1$4d|%2$4d|%3$4d|%4$4d|%5$4d|%6$4d|", "12", "-12", "123", "-123", "12345", "-12345"));
    }
}
