
package javatest;

import org.junit.Test;
import java.math.BigDecimal;

public class DoubleTest {
    @Test
    public void test_int_to_double() {
        final int i = Integer.MAX_VALUE;
        final double d = i;
        System.out.println(i); // 2147483647
        System.out.println(d); // 2.147483647E9
    }

    @Test
    public void test_long_to_double() {
        final long l = Long.MAX_VALUE;
        final double d = l;
        System.out.println(l); // 9223372036854775807
        System.out.println(d); // 9.223372036854776E18
    }

    @Test
    public void test_BigInteger_to_double() {
        final BigDecimal b = new BigDecimal("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        final double d = b.doubleValue();
        System.out.println(b); // 1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
        System.out.println(d); // Infinity
    }
}
