
package javatest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

public class MimeTypeTest {
    @Test
    public void test_ParsingContentTypeLiteral() throws MimeTypeParseException {
        final String tmp = "application/json; charset=UTF-8";
        final MimeType theMimeType = new MimeType(tmp); // the constructor will throw MimeTypeParseException, that is a checked exception
        assertEquals("application/json", theMimeType.getBaseType());
        assertEquals("UTF-8", theMimeType.getParameter("charset"));
    }

    @Test
    public void test_ParsingContentTypeLiteral_QuotedParameterValue() throws MimeTypeParseException {
        final String tmp = "application/json; charset=\"UTF-16 BE\"";
        final MimeType theMimeType = new MimeType(tmp); // the constructor will throw MimeTypeParseException, that is a checked exception
        assertEquals("application/json", theMimeType.getBaseType());
        assertEquals("UTF-16 BE", theMimeType.getParameter("charset"));
    }

    @Test
    public void test_ParsingContentTypeLiteral_CapitalLetter() throws MimeTypeParseException {
        final String tmp = "APPLICATION/JSON; CHARSET=UTF-8";
        final MimeType theMimeType = new MimeType(tmp); // the constructor will throw MimeTypeParseException, that is a checked exception
        assertEquals("application/json", theMimeType.getBaseType());
        assertEquals("UTF-8", theMimeType.getParameter("charset"));
    }

    @Test
    public void test_ParsingContentTypeLiteral_SpaceInsertedBetweenTokens_TwoParameters() throws MimeTypeParseException {
        final String tmp = "hoge / fuga ; foo = \"A=B=C\" ; Bar = XYZ";
        final MimeType theMimeType = new MimeType(tmp); // the constructor will throw MimeTypeParseException, that is a checked exception
        assertEquals("hoge/fuga", theMimeType.getBaseType());
        assertEquals("A=B=C", theMimeType.getParameter("foo"));
        assertEquals("XYZ", theMimeType.getParameter("bar"));
    }

    @Test
    public void test_ConstructContentType() throws MimeTypeParseException {
        final MimeType theMimeType = new MimeType();
        theMimeType.setPrimaryType("HOGE");
        theMimeType.setSubType("Fuga");
        theMimeType.setParameter("Bar", "A=B=C");
        theMimeType.setParameter("foo", "XYZ");
        assertEquals("hoge/fuga; bar=\"A=B=C\"; foo=XYZ", theMimeType.toString());
    }
}
