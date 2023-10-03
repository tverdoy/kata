package tverdoy;

public class Calculator {
    private final SyntaxTree syntaxTree;

    protected Calculator(SyntaxTree syntaxTree) {
        this.syntaxTree = syntaxTree;
    }

    protected String calculateToString() {
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
            return RomanConvertor.toRoman(result);
        }
    }
}
