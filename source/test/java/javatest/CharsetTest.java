
package javatest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.nio.charset.Charset;

public class CharsetTest {

    // system's default

    @Test
    public void test_defaultCharset() {
        assertEquals("UTF-8", Charset.defaultCharset().name());
    }

    // historical Java encoding name

    @Test
    public void test_historical_ASCII() {
        assertEquals("US-ASCII", Charset.forName("ASCII").name());
    }

    @Test
    public void test_historical_ISO8859_1() {
        assertEquals("ISO-8859-1", Charset.forName("ISO8859_1").name());
    }

    @Test
    public void test_historical_UTF8() {
        assertEquals("UTF-8", Charset.forName("UTF8").name());
    }

    @Test
    public void test_historical_SJIS() {
        assertEquals("Shift_JIS", Charset.forName("SJIS").name());
    }

    @Test
    public void test_historical_MS932() {
        assertEquals("windows-31j", Charset.forName("MS932").name());
    }

    @Test
    public void test_historical_Cp943C() {
        assertEquals("x-IBM943C", Charset.forName("Cp943C").name());
    }

    @Test
    public void test_historical_EUC_JP() {
        assertEquals("EUC-JP", Charset.forName("EUC_JP").name());
    }

    @Test
    public void test_historical_ISO2022JP() {
        assertEquals("ISO-2022-JP", Charset.forName("ISO2022JP").name());
    }

    // MIME charset

    @Test
    public void test_mime_US_ASCII() {
        assertEquals("US-ASCII", Charset.forName("US-ASCII").name());
    }

    @Test
    public void test_mime_ISO_8859_1() {
        assertEquals("ISO-8859-1", Charset.forName("ISO-8859-1").name());
    }

    @Test
    public void test_mime_UTF_8() {
        assertEquals("UTF-8", Charset.forName("UTF-8").name());
    }

    @Test
    public void test_mime_Shift_JIS() {
        assertEquals("Shift_JIS", Charset.forName("Shift_JIS").name());
    }

    @Test
    public void test_mime_Windows_31J() {
        assertEquals("windows-31j", Charset.forName("Windows-31J").name());
    }

    @Test
    public void test_mime_EUC_JP() {
        assertEquals("EUC-JP", Charset.forName("EUC-JP").name());
    }

    @Test
    public void test_mime_ISO_2022_JP() {
        assertEquals("ISO-2022-JP", Charset.forName("ISO-2022-JP").name());
    }
}
