package tverdoy;

import junit.framework.TestCase;

public class SyntaxTreeTest extends TestCase {

    public void testPlusParseArabic() throws Exception {
        SyntaxTree syntaxTree = SyntaxTree.parse("1 + 2");

        assertEquals(syntaxTree.getFirstArgument(), 1);
        assertEquals(syntaxTree.getSecondArgument(), 2);
        assertEquals(syntaxTree.getOperator(), "+");
    }

    public void testSubtractParseArabic() throws Exception {
        SyntaxTree syntaxTree = SyntaxTree.parse("6 - 3");

        assertEquals(syntaxTree.getFirstArgument(), 6);
        assertEquals(syntaxTree.getSecondArgument(), 3);
        assertEquals(syntaxTree.getOperator(), "-");
    }

//    public void testMultiplyParseRomans() throws Exception {
//        SyntaxTree syntaxTree = SyntaxTree.parse("IV * II");
//
//        assertEquals(syntaxTree.getFirstArgument(), 4);
//        assertEquals(syntaxTree.getSecondArgument(), 2);
//        assertEquals(syntaxTree.getOperator(), "*");
//    }
}