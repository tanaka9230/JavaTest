
package javatest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

@SuppressWarnings("boxing")
public class AutoboxingTest {
    int intval127 = 127;
    int intval1024 = 1024;

    @Test
    public void test_Integer127_to_int127_OK() {
        final boolean f = new Integer(intval127) == intval127;
        assertEquals(true, f);
    }

    @Test
    public void test_int127_to_Integer127_OK() {
        final boolean f = intval127 == new Integer(intval127);
        assertEquals(true, f);
    }

    @Test
    public void test_Integer127_to_Integer127_NG() {
        final boolean f = new Integer(intval127) == new Integer(intval127);
        assertEquals(false, f);
    }

    @Test
    public void test_assigned_Integer127_to_assigned_Integer127_OK() {
        final Integer arg1 = intval127;
        final Integer arg2 = intval127;
        final boolean f = arg1 == arg2;
        assertEquals(true, f);
    }

    @Test
    public void test_Integer1024_to_int1024_OK() {
        final boolean f = new Integer(intval1024) == intval1024;
        assertEquals(true, f);
    }

    @Test
    public void test_int1024_to_Integer1024_OK() {
        final boolean f = intval1024 == new Integer(intval1024);
        assertEquals(true, f);
    }

    @Test
    public void test_Integer1024_to_Integer1024_NG() {
        final boolean f = new Integer(intval1024) == new Integer(intval1024);
        assertEquals(false, f);
    }

    @Test
    public void test_assigned_Integer1024_to_assigned_Integer1024_NG() {
        final Integer arg1 = intval1024;
        final Integer arg2 = intval1024;
        final boolean f = arg1 == arg2;
        assertEquals(false, f);
    }
}
