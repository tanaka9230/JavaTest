package javatest;

import static org.junit.Assert.assertEquals;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.junit.Test;

public class MatcherTest
{
    @Test
    public void test_matched() {
        Matcher m = Pattern.compile("(.*) \\- (.*)\\.jpg").matcher("BaseName - 123.jpg");
        assertEquals(true, m.find());
        assertEquals(2, m.groupCount());
        assertEquals("BaseName", m.group(1));
        assertEquals("123", m.group(2));
    }

    @Test
    public void test_not_matched() {
        Matcher m = Pattern.compile("(.*) \\- (.*)\\.jpg").matcher("BaseName-123.jpg");
        assertEquals(false, m.find());
        assertEquals(2, m.groupCount());
        //assertEquals(null, m.group(1)); // this causes `java.lang.IllegalStateException: No match found`
        //assertEquals(null, m.group(2)); // this causes `java.lang.IllegalStateException: No match found`
    }
}
