package tverdoy;

import java.util.regex.Pattern;

public class SyntaxTree {
    private static final String[] supportOperators = {"+", "-", "*", "/"};

    private final int firstArgument;
    private final int secondArgument;
    private final String operator;
    private final boolean argumentsIsArabic;

    public SyntaxTree(int firstArgument, int secondArgument, String operator, boolean argumentsIsArabic) {
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
        this.operator = operator;
        this.argumentsIsArabic = argumentsIsArabic;
    }

    /**
     * @param input target string that parse
     * @return syntax tree
     * @throws Exception if invalid syntax or arguments in different systems
     */
    protected static SyntaxTree parse(String input) throws Exception {
        String inputWithoutSpace = input.replace(" ", "");

        for (String supportOperator : supportOperators) {
            if (inputWithoutSpace.contains(supportOperator)) {
                String[] inputSplit = inputWithoutSpace.split(Pattern.quote(supportOperator));
                if (inputSplit.length != 2) {
                    throw new Exception("Invalid syntax");
                }

                if (RomanConvertor.isRoman(inputSplit[0])) {
                    if (RomanConvertor.isRoman(inputSplit[1])) {
                        // First and second argument is roman

                        int firstArgument = RomanConvertor.toArabic(inputSplit[0]);
                        int secondArgument = RomanConvertor.toArabic(inputSplit[1]);

                        return new SyntaxTree(firstArgument, secondArgument, supportOperator, false);
                    } else {
                        // First argument is roman and second argument is arabic

                        throw new Exception("Both arguments must be either Arabic or Roman");
                    }
                } else if (RomanConvertor.isRoman(inputSplit[1])) {
                    // First argument is arabic and second argument is roman

                    throw new Exception("Both arguments must be either Arabic or Roman");
                } else {
                    // First and second argument is arabic

                    int firstArgument = Integer.parseInt(inputSplit[0]);
                    int secondArgument = Integer.parseInt(inputSplit[1]);

                    return new SyntaxTree(firstArgument, secondArgument, supportOperator, true);
                }
            }
        }

        throw new Exception("Invalid syntax");
    }

    public int getFirstArgument() {
        return firstArgument;
    }

    public int getSecondArgument() {
        return secondArgument;
    }

    public String getOperator() {
        return operator;
    }

    public boolean isArgumentsIsArabic() {
        return argumentsIsArabic;
    }
}
