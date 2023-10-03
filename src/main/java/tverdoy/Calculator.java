package tverdoy;

public class Calculator {
    private final SyntaxTree syntaxTree;

    protected Calculator(SyntaxTree syntaxTree) {
        this.syntaxTree = syntaxTree;
    }

    /**
     * @return result of calculate
     * @throws Exception if negative result and output in Roman
     */
    protected String calculateToString() throws Exception {
        int result;

        switch (syntaxTree.getOperator()) {
            case "+" -> result = syntaxTree.getFirstArgument() + syntaxTree.getSecondArgument();
            case "-" -> result = syntaxTree.getFirstArgument() - syntaxTree.getSecondArgument();
            case "/" -> result = syntaxTree.getFirstArgument() / syntaxTree.getSecondArgument();
            case "*" -> result = syntaxTree.getFirstArgument() * syntaxTree.getSecondArgument();
            default -> throw new Error("Unknown operator");
        }

        if (syntaxTree.isArgumentsIsArabic()) {
            return String.valueOf(result);
        } else {
            if (result == 0) {
                return "";
            }

            if (result < 0) {
                throw new Exception("It is not possible to have a negative result in Roman");
            }
            return RomanConvertor.toRoman(result);
        }
    }
}
