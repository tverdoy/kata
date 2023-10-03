package tverdoy;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    public void testCalculateToStringArabic() throws Exception {
        SyntaxTree syntaxTree = SyntaxTree.parse("1 + 2");
        Calculator calculator = new Calculator(syntaxTree);

        assertEquals(calculator.calculateToString(), "3");
    }

    public void testCalculateToStringRoman() throws Exception {
        SyntaxTree syntaxTree = SyntaxTree.parse("IV * VII");
        Calculator calculator = new Calculator(syntaxTree);

        assertEquals(calculator.calculateToString(), "XXVIII");
    }

    public void testCalculateToStringRomanLessZero() throws Exception {
        SyntaxTree syntaxTree = SyntaxTree.parse("IV - VII");
        Calculator calculator = new Calculator(syntaxTree);

        try {
            calculator.calculateToString();
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "It is not possible to have a negative result in Roman");
        }
    }
}