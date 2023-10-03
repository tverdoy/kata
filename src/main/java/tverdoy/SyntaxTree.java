package tverdoy;

import java.util.regex.Pattern;

public class SyntaxTree {
    private static final String[] supportOperators = {"+", "-", "*", "/"};


    private final int firstArgument;
    private final int secondArgument;
    private final String operator;

    public SyntaxTree(int firstArgument, int secondArgument, String operator) {
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
        this.operator = operator;
    }

    /**
     * @param input target string that parse
     * @return syntax tree
     * @throws Exception if invalid syntax
     */
    protected static SyntaxTree parse(String input) throws Exception {
        String inputWithoutSpace = input.replace(" ", "");

        for (String supportOperator : supportOperators) {
            if (inputWithoutSpace.contains(supportOperator)) {
                String[] inputSplit = inputWithoutSpace.split(Pattern.quote(supportOperator));
                if (inputSplit.length != 2) {
                    throw new Exception("Invalid syntax");
                }

                int firstArgument = Integer.parseInt(inputSplit[0]);
                int secondArgument = Integer.parseInt(inputSplit[1]);

                return new SyntaxTree(firstArgument, secondArgument, supportOperator);

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
}
