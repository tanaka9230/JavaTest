package javatest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringSplitTest
{
    @Test
    public void test_1() {
        String[] s = "a, b ,  c  ,, ,,, , d ".split("\\,");
        assertEquals(9, s.length);
        assertEquals("a", s[0]);
        assertEquals(" b ", s[1]);
        assertEquals("  c  ", s[2]);
        assertEquals("", s[3]);
        assertEquals(" ", s[4]);
        assertEquals("", s[5]);
        assertEquals("", s[6]);
        assertEquals(" ", s[7]);
        assertEquals(" d ", s[8]);
    }
}
