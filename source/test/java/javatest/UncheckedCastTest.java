
package javatest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UncheckedCastTest {
    @Test
    public void test1() {
        final Map<Serializable, Serializable> theMap = new HashMap<Serializable, Serializable>();
        theMap.put(Integer.valueOf(1), "abc");
        final Object tmp = theMap;
        @SuppressWarnings("unchecked")
        final Map<String, Integer> got = (Map<String, Integer>)tmp; // here no exception is thrown
        for (final Entry<String, Integer> it : got.entrySet()) {
            try {
                @SuppressWarnings("unused")
                final String theKey = it.getKey(); // ClassCastException is thrown at this point
                fail();
            } catch (final ClassCastException e) {
                assertEquals("java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String", e.toString());
            }
            try {
                @SuppressWarnings("unused")
                final Integer theValue = it.getValue(); // ClassCastException is thrown at this point
                fail();
            } catch (final ClassCastException e) {
                assertEquals("java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer", e.toString());
            }
            break;
        }
    }
}
