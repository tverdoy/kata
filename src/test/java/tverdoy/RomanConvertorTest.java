package tverdoy;

import junit.framework.TestCase;

public class RomanConvertorTest extends TestCase {

    public void testIsRomanTrur() {
        assertTrue(RomanConvertor.isRoman("III"));
        assertTrue(RomanConvertor.isRoman("IV"));
        assertTrue(RomanConvertor.isRoman("IV"));
        assertTrue(RomanConvertor.isRoman("XL"));
    }

    public void testIsRomanFalse() {
        assertFalse(RomanConvertor.isRoman("5"));
        assertFalse(RomanConvertor.isRoman("II2"));
        assertFalse(RomanConvertor.isRoman("V4I"));

    }
}