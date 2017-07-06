
package javatest;

import org.junit.Test;
import java.math.BigDecimal;

public class DoubleTest {
    @Test
    public void test_int_to_double() {
        final int i = Integer.MAX_VALUE;
        final double d = i;
        System.out.println(i);
        System.out.println(d);
    }

    @Test
    public void test_long_to_double() {
        final long l = Long.MAX_VALUE;
        final double d = l;
        System.out.println(l);
        System.out.println(d);
    }

    @Test
    public void test_BigInteger_to_double() {
        final BigDecimal b = new BigDecimal("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        final double d = b.doubleValue();
        System.out.println(b);
        System.out.println(d);
    }
}
