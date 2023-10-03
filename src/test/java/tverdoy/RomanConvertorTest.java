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

    public void testToArabic() {
        assertEquals(RomanConvertor.toArabic("III"), 3);
        assertEquals(RomanConvertor.toArabic("IV"), 4);
        assertEquals(RomanConvertor.toArabic("XIX"), 19);
    }

    public void testTestToArabic() {
        assertEquals(RomanConvertor.toRoman(3), "III");
        assertEquals(RomanConvertor.toRoman(4), "IV");
        assertEquals(RomanConvertor.toRoman(19), "XIX");
    }
}